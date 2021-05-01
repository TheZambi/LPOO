package com.g75.Controller;

import com.g75.Commands.CommandDown;
import com.g75.Commands.CommandLeft;
import com.g75.Commands.CommandUp;
import com.g75.Controller.LevelController;
import com.g75.Controller.LinkController;
import com.g75.Controller.MovableStoneController;
import com.g75.Model.*;
import com.g75.View.ArenaView;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MoveableStoneTests {
    @Test
    public  void stoneMovedRightAndLeft() throws IOException {
        ArenaModel arenaModel = new ArenaModel();
        arenaModel.getMapModels().clear();
        arenaModel.addMap();
        arenaModel.getMapModels().get(0).addLevel();
        arenaModel.getMapModels().get(0).getLevelModels().get(0).addStone(new MovableStoneModel(new Position(78,50)));
        Position newPosition = new Position(54,50);
        LevelController levelController = new LevelController();
        LinkController linkController = new LinkController();
        ArenaView arenaView = new ArenaView();

        Integer x,y;
        linkController.chechForMoveableStone(arenaModel,newPosition,levelController,arenaView);
        x = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().x;
        y = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().y;
        Integer realX = 81,realY = 50;
        assertEquals(x,realX);
        assertEquals(y,realY);

        //arenaModel.getLinkModel().setPosition(new Position(104,50));
        newPosition = new Position(90,50);
        arenaModel.getLinkModel().setOrientation(new CommandLeft());
        linkController.chechForMoveableStone(arenaModel,newPosition,levelController,arenaView);
        x = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().x;
        y = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().y;
        realX = 78;
        realY = 50;
        assertEquals(realX,x);
        assertEquals(realY,y);


    }


    @Test
    public  void stoneMovedUpAndDown() throws IOException {
        ArenaModel arenaModel = new ArenaModel();
        arenaModel.getMapModels().clear();
        arenaModel.addMap();
        arenaModel.getMapModels().get(0).addLevel();
        arenaModel.getMapModels().get(0).getLevelModels().get(0).addStone(new MovableStoneModel(new Position(100,50)));
        Position newPosition = new Position(100,64);
        LevelController levelController = new LevelController();
        LinkController linkController = new LinkController();
        ArenaView arenaView = new ArenaView();

        arenaModel.getLinkModel().setOrientation(new CommandUp());
        Integer x,y;
        linkController.chechForMoveableStone(arenaModel,newPosition,levelController,arenaView);
        x = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().x;
        y = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().y;
        Integer realX = 100,realY = 48;
        assertEquals(realX,x);
        assertEquals(realY,y);

        //arenaModel.getLinkModel().setPosition(new Position(104,50));
        newPosition = new Position(100,40);
        arenaModel.getLinkModel().setOrientation(new CommandDown());
        linkController.chechForMoveableStone(arenaModel,newPosition,levelController,arenaView);
        x = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().x;
        y = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().y;
        realX = 100;
        realY = 50;
        assertEquals(realX,x);
        assertEquals(realY,y);


    }
    @Test
    public  void stoneMovedUp() throws IOException {
        ArenaModel arenaModel = new ArenaModel();
        arenaModel.getMapModels().clear();
        arenaModel.addMap();
        arenaModel.getMapModels().get(0).addLevel();
        arenaModel.getMapModels().get(0).getLevelModels().get(0).addStone(new MovableStoneModel(new Position(50,65)));
        Position newPosition = new Position(50,52);
        LevelController levelController = new LevelController();
        LinkController linkController = new LinkController();
        ArenaView arenaView = new ArenaView();
        CommandDown cmd = new CommandDown();
        arenaModel.getLinkModel().setOrientation(cmd);

        linkController.chechForMoveableStone(arenaModel,newPosition,levelController,arenaView);

        Integer x,y;
        x = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().x;
        y = arenaModel.getMapModels().get(0).getLevelModels().get(0).getStoneModels().get(0).getPosition().y;
        Integer realX = 50,realY = 67;
        assertEquals(x,realX);
        assertEquals(y,realY);
    }
    @Test
    public  void cannotMove(){
        MovableStoneModel movableStoneModel = new MovableStoneModel(new Position( -100,100));
        LevelModel levelModel = new LevelModel();
        ArenaView arenaView = new ArenaView();
        MovableStoneController movableStoneController = new MovableStoneController();
        levelModel.addEnemy(new OrcEnemyModel(new Position(100,100)));
        levelModel.addObstacle(new GreenBushModel(new Position(300, 100)));
        levelModel.addStone(new MovableStoneModel(new Position(200,100)));


        Integer expectedX = -100;
        Integer expectedY = 100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);


        movableStoneModel.setPosition(new Position(600,100));
        expectedX = 600;
        expectedY = 100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);

        movableStoneModel.setPosition(new Position(100,-100));
        expectedX = 100;
        expectedY = -100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);

        movableStoneModel.setPosition(new Position(100,300));
        expectedX = 100;
        expectedY = 300;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);

        movableStoneModel.setPosition(new Position(90,100));
        expectedX = 90;
        expectedY = 100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);

        movableStoneModel.setPosition(new Position(290,100));
        expectedX = 290;
        expectedY = 100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);

        movableStoneModel.setPosition(new Position(190,100));
        expectedX = 190;
        expectedY = 100;

        movableStoneController.moveStone(movableStoneModel,levelModel,arenaView,0);

        assertEquals(expectedX,movableStoneModel.getPosition().x);
        assertEquals(expectedY,movableStoneModel.getPosition().y);
    }
}

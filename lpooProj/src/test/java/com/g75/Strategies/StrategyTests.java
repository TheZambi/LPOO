package com.g75.Strategies;

import com.g75.Controller.BatEnemyController;
import com.g75.Controller.OrcEnemyController;
import com.g75.Model.*;
import com.g75.Strategies.OrcEnemyStrategy;
import com.g75.View.LevelView;
import org.junit.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertEquals;


public class StrategyTests {
    @Test
    public void orcStratTest() {
        OrcEnemyStrategy orcEnemyStrategy = new OrcEnemyStrategy();
        Position linkPosition = new Position(100,100);
        Position orcPosition = new Position(10,100);


        Position newPos = orcEnemyStrategy.getNextMove(orcPosition,linkPosition);

        Integer testX = 12;
        Integer testY = 100;
        assertEquals(testX,newPos.x);
        assertEquals(testY,newPos.y);

        orcPosition = new Position(10,200);

        newPos = orcEnemyStrategy.getNextMove(orcPosition,linkPosition);

        testX = 10;
        testY = 199;
        assertEquals(testX,newPos.x);
        assertEquals(testY,newPos.y);

        orcPosition = new Position(100,0);

        newPos = orcEnemyStrategy.getNextMove(orcPosition,linkPosition);

        testX = 100;
        testY = 1;
        assertEquals(testX,newPos.x);
        assertEquals(testY,newPos.y);

        orcPosition = new Position(200,100);

        newPos = orcEnemyStrategy.getNextMove(orcPosition,linkPosition);

        testX = 198;
        testY = 100;
        assertEquals(testX,newPos.x);
        assertEquals(testY,newPos.y);

    }

    @Test
    public void orcStratTestWithObstacle() {
        OrcEnemyModel orcEnemyModel = new OrcEnemyModel(new Position(10,100));
        LinkModel linkModel = new LinkModel(new Position(100,100));
        LevelModel levelModel = new LevelModel();
        LevelView levelView = new LevelView();
        levelModel.addObstacle(new GreenBushModel(new Position(37,100)));
        OrcEnemyController orcEnemyController = new OrcEnemyController();
        levelModel.addStone(new MovableStoneModel(new Position(200,100)));

        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        Integer testX = 10;
        Integer testY = 100;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(10,200));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);


        testX = 10;
        testY = 101;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(300,100));
        orcEnemyModel.setPosition(new Position(190,100));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        testX = 190;
        testY = 100;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        orcEnemyModel.setPosition(new Position(-100,100));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        testX = -100;
        testY = 100;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        orcEnemyModel.setPosition(new Position(500,100));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        testX = 500;
        testY = 100;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        orcEnemyModel.setPosition(new Position(200,-100));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        testX = 200;
        testY = -100;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);

        orcEnemyModel.setPosition(new Position(200,300));
        orcEnemyController.update(orcEnemyModel,linkModel,levelView,levelModel);

        testX = 200;
        testY = 300;
        assertEquals(testX,orcEnemyModel.getPosition().x);
        assertEquals(testY,orcEnemyModel.getPosition().y);
    }

    @Test
    public void batStratTest() {
        BatEnemyModel batEnemyModel = new BatEnemyModel(new Position(200,100));
        LinkModel linkModel = new LinkModel(new Position(50,30));


        Position newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());
        assertEquals(newPosition.x,batEnemyModel.getPosition().x);
        assertEquals(newPosition.y,batEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(175, 80));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        Integer realX = batEnemyModel.getPosition().x-2;
        assertEquals(newPosition.x,realX);
        assertEquals(newPosition.y,batEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(190, 50));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        Integer realY = batEnemyModel.getPosition().y-1;
        assertEquals(newPosition.x,batEnemyModel.getPosition().x);
        assertEquals(newPosition.y,realY);

        linkModel.setPosition(new Position(210, 100));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        realX = batEnemyModel.getPosition().x+2;
        assertEquals(newPosition.x,realX);
        assertEquals(newPosition.y,batEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(200, 150));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        realY = batEnemyModel.getPosition().y+1;
        assertEquals(newPosition.x,batEnemyModel.getPosition().x);
        assertEquals(newPosition.y,realY);


        linkModel.setPosition(new Position(200, 200));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        realY = batEnemyModel.getPosition().y;
        assertEquals(newPosition.x,batEnemyModel.getPosition().x);
        assertEquals(newPosition.y,realY);

        linkModel.setPosition(new Position(400, 100));

        newPosition = batEnemyModel.getMoveStrategy().getNextMove(batEnemyModel.getPosition(),linkModel.getPosition());

        realX = batEnemyModel.getPosition().x;
        assertEquals(newPosition.x,realX);
        assertEquals(newPosition.y,batEnemyModel.getPosition().y);
    }

    @Test
    public void batStratTestWithBush() {
        BatEnemyController batEnemyController = new BatEnemyController();
        BatEnemyModel batEnemyModel = new BatEnemyModel(new Position(200,100));
        LinkModel linkModel = new LinkModel(new Position(50,30));
        LevelModel levelModel = new LevelModel();
        LevelView levelView = new LevelView();

        levelModel.addObstacle(new GreenBushModel(new Position(174,100)));

        batEnemyController.update(batEnemyModel,linkModel,levelView, levelModel);
        Integer expectedX, expectedY;
        expectedX=200;
        expectedY=100;
        assertEquals(expectedX,batEnemyModel.getPosition().x);
        assertEquals(expectedY,batEnemyModel.getPosition().y);

        linkModel.setPosition(new Position(160, 100));

        batEnemyController.update(batEnemyModel,linkModel,levelView, levelModel);
        batEnemyController.update(batEnemyModel,linkModel,levelView, levelModel);

        expectedX=196;
        expectedY=100;
        assertEquals(expectedX,batEnemyModel.getPosition().x);
        assertEquals(expectedY,batEnemyModel.getPosition().y);

    }
    @Test
    public void ghostBossStrategy(){
        LinkModel link = new LinkModel(new Position(50,50));
        GhostBossModel boss = new GhostBossModel(new Position(200,100));

        Position newPos = boss.getMoveStrategy().getNextMove(boss.getPosition(),link.getPosition(),0);
        Integer expectedX, expectedY;
        expectedX=197;
        expectedY=100;
        assertEquals(expectedX,newPos.x);
        assertEquals(expectedY,newPos.y);

        link.setPosition(new Position(200,50));
        newPos = boss.getMoveStrategy().getNextMove(boss.getPosition(),link.getPosition(),0);
        expectedX=200;
        expectedY=98;
        assertEquals(expectedX,newPos.x);
        assertEquals(expectedY,newPos.y);
    }

    @Test
    public void wizardBossStrategy(){
        LinkModel link = new LinkModel(new Position(50,50));
        WizardBossModel boss = new WizardBossModel(new Position(200,100));

        Position newPos = boss.getMoveStrategy().getNextMove(boss.getPosition(),link.getPosition(),0);
        Integer expectedX, expectedY;
        expectedX=200;
        expectedY=100;
        assertEquals(expectedX,newPos.x);
        assertEquals(expectedY,newPos.y);

    }
}

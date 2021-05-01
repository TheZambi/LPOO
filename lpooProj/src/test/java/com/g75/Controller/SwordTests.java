package com.g75.Controller;

import com.g75.Commands.CommandAttack;
import com.g75.Commands.CommandDown;
import com.g75.Commands.CommandUp;
import com.g75.Controller.LevelController;
import com.g75.Controller.LinkController;
import com.g75.Controller.SwordController;
import com.g75.Model.*;
import com.g75.View.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SwordTests {
    @Test
    public void UpdateTest() {
        LinkModel linkModel = new LinkModel( new Position(100,100));
        LevelModel levelModel = new LevelModel();
        ArenaView arenaView = new ArenaView();
        LevelController levelController = new LevelController();
        SwordController swordController = new SwordController();

        swordController.update(linkModel, levelModel, arenaView, levelController);

        Integer expectedX = 126, expectedY = 105;

        assertEquals(expectedX, linkModel.getSword().getPosition().x);
        assertEquals(expectedY, linkModel.getSword().getPosition().y);

        linkModel.setOrientation(new CommandDown());

        expectedX = 110;
        expectedY = 115;

        swordController.update(linkModel, levelModel, arenaView, levelController);

        assertEquals(expectedX, linkModel.getSword().getPosition().x);
        assertEquals(expectedY, linkModel.getSword().getPosition().y);

    }

    @Test
    public void DefeatEnemyTest() {
        LinkModel linkModel = new LinkModel( new Position(100,100));
        LevelModel levelModel = new LevelModel();
        ArenaView arenaView = new ArenaView();
        LevelController levelController = new LevelController();
        SwordController swordController = new SwordController();

        levelModel.addStair(new StairModel(new Position(100,100),1));
        levelModel.addEnemy(new OrcEnemyModel(new Position(126,105)));
        levelModel.addEnemy(new OrcEnemyModel(new Position(110,115)));
        levelModel.setBoss(new GhostBossModel(new Position(110,51)));


        assertEquals(1,levelModel.getStairModels().get(0).getNextMap());
        assertEquals(0,levelModel.getStairModels().get(0).getIsActive());
        assertEquals(2, levelModel.getEnemies().size());
        assertNotEquals(null, levelModel.getBosses());

        swordController.update(linkModel, levelModel, arenaView, levelController);

        assertEquals(1, levelModel.getEnemies().size());
        assertNotEquals(null, levelModel.getBosses());

        linkModel.setOrientation(new CommandDown());

        swordController.update(linkModel, levelModel, arenaView, levelController);

        assertEquals(0, levelModel.getEnemies().size());
        assertNotEquals(null, levelModel.getBosses());

        linkModel.setOrientation(new CommandUp());

        swordController.update(linkModel, levelModel, arenaView, levelController);

        assertEquals(0, levelModel.getEnemies().size());
        assertEquals(null, levelModel.getBosses());

        assertEquals(1,levelModel.getStairModels().get(0).getIsActive());
    }
}

package com.g75.Controller;
import com.g75.Controller.BossEnemyController;
import com.g75.Controller.GhostBossController;
import com.g75.Model.*;
import com.g75.View.LevelView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GhostBossTests {
    @Test
    public void ghostStratWithoutImmunityTest(){
        LinkModel linkModel = new LinkModel(new Position(50,100));
        LevelView levelView = new LevelView();
        LevelModel levelModel = new LevelModel();
        GhostBossModel ghostBossModel = new GhostBossModel(new Position(100, 100));
        GhostBossController bossController = new GhostBossController();

        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        Integer expectedX = 97, expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        linkModel.setPosition(new Position(150, 100));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 100;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        linkModel.setPosition(new Position(104, 98));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 103;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 103;
        expectedY = 98;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        linkModel.setPosition(new Position(103,200));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 103;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        ghostBossModel.setPosition(new Position(-100,1));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = -100;
        expectedY = 1;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);


        ghostBossModel.setPosition(new Position(1,-100));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedY = -100;
        expectedX = 1;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);


        ghostBossModel.setPosition(new Position(500,1));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 500;
        expectedY = 1;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);


        ghostBossModel.setPosition(new Position(1,200));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 1;
        expectedY = 200;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

    }

    @Test
    public void ghostStratWithImmunityTest(){
        LinkModel linkModel = new LinkModel(new Position(50,100));
        LevelView levelView = new LevelView();
        LevelModel levelModel = new LevelModel();
        GhostBossModel ghostBossModel = new GhostBossModel(new Position(100, 100));
        ghostBossModel.setInvulnerability(100);
        GhostBossController bossController = new GhostBossController();

        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        Integer expectedX = 103, expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        linkModel.setPosition(new Position(150, 100));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 100;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        linkModel.setPosition(new Position(104, 98));
        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 97;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        bossController.update(ghostBossModel,linkModel,levelView,levelModel);

        expectedX = 94;
        expectedY = 100;

        assertEquals(expectedX, ghostBossModel.getPosition().x);
        assertEquals(expectedY, ghostBossModel.getPosition().y);

        assertEquals(96, ghostBossModel.getInvulnerability()); // each time update is called invulnerability decreases by 1
    }
}

package com.g75.Controller;

import com.g75.Controller.WizardBossController;
import com.g75.Model.LevelModel;
import com.g75.Model.LinkModel;
import com.g75.Model.Position;
import com.g75.Model.WizardBossModel;
import com.g75.View.LevelView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WizardBossTest {
    @Test
    public void MoveTest() {
        WizardBossModel wizardBossModel = new WizardBossModel(new Position(10,10));
        Integer expectedX = 10, expectedY = 10;

        Position newPos = wizardBossModel.getMoveStrategy().getNextMove(wizardBossModel.getPosition(),new Position(10,20),0);

        assertEquals(expectedX, newPos.x);
        assertEquals(expectedY, newPos.y);

    }

    @Test
    public void TestTP() {
        WizardBossModel wizardBossModel = new WizardBossModel(new Position(10,10));
        Integer expectedX = 10, expectedY = 10;
        WizardBossController wizardBossController = new WizardBossController();
        LevelModel levelModel = new LevelModel();
        levelModel.setBoss(wizardBossModel);

        Position newPos = wizardBossModel.getMoveStrategy().getNextMove(wizardBossModel.getPosition(),new Position(10,20),0);

        assertEquals(expectedX, newPos.x);
        assertEquals(expectedY, newPos.y);

        wizardBossController.hitReaction(wizardBossModel,levelModel);
        newPos = wizardBossModel.getMoveStrategy().getNextMove(wizardBossModel.getPosition(),new Position(10,20),0);

        Integer expectedHP = 2;
        expectedX = 170;
        expectedY = 125;

        assertEquals(expectedHP,wizardBossModel.getHP());
        assertEquals(expectedX, newPos.x);
        assertEquals(expectedY, newPos.y);

        wizardBossController.hitReaction(wizardBossModel,levelModel);
        newPos = wizardBossModel.getMoveStrategy().getNextMove(wizardBossModel.getPosition(),new Position(10,20),0);

        expectedHP = 1;
        expectedX = 2;
        expectedY = 20;

        assertEquals(expectedHP,wizardBossModel.getHP());
        assertEquals(expectedX, newPos.x);
        assertEquals(expectedY, newPos.y);

        wizardBossController.hitReaction(wizardBossModel,levelModel);
        assertNull(levelModel.getBosses());
    }

    @Test
    public void TestSpawn() {
        WizardBossModel boss = new WizardBossModel();
        LinkModel linkModel = new LinkModel();
        LevelView levelView = new LevelView();
        LevelModel levelModel = new LevelModel();
        levelModel.setBoss(boss);
        WizardBossController wizardBossController = new WizardBossController();

        assertEquals(0,levelModel.getEnemies().size());

        wizardBossController.update(boss,linkModel,levelView,levelModel);

        assertEquals(1,levelModel.getEnemies().size());

        for(int i = 0 ; i <=20 ;i++)
            wizardBossController.update(boss,linkModel,levelView,levelModel);

        assertEquals(2,levelModel.getEnemies().size());
    }


}

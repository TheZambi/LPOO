package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;

import java.util.HashMap;


public class LevelController {
    HashMap<Integer,EnemyController> modelToController;
    HashMap<Integer,BossEnemyController>  bossControllers;
    MovableStoneController stoneController;


    public LevelController(){
        stoneController = new MovableStoneController();
        modelToController = new HashMap<>();
        bossControllers = new HashMap<>();
        OrcEnemyController orcEnemyController = new OrcEnemyController();
        BatEnemyController batEnemyController = new BatEnemyController();
        GhostBossController ghostBossController = new GhostBossController();
        WizardBossController wizardBossController = new WizardBossController();
        bossControllers.put(0,ghostBossController);
        bossControllers.put(1,wizardBossController);
        modelToController.put(0,orcEnemyController);
        modelToController.put(1,batEnemyController);
    }

    public void update(LinkModel linkModel, LevelModel levelModel, LevelView levelView) {
        for(EnemyModel em : levelModel.getEnemies())
            modelToController.get(em.getTableID()).update(em,linkModel, levelView, levelModel);

        if(levelModel.getBosses() != null)
            bossControllers.get(levelModel.getBosses().getId()).update(levelModel.getBosses(),linkModel,levelView, levelModel);


    }

    public void removeEnemy(int i,LevelModel levelModel) {
        levelModel.getEnemies().remove(i);
    }


    public MovableStoneController getStoneController() {
        return stoneController;
    }

    public void removeKey(LevelModel levelModel, int counter) {
        levelModel.getKeys().remove(counter);
    }

    public void bossGotHit(BossModel bossModel,LevelModel levelModel) {
        bossControllers.get(bossModel.getId()).hitReaction(bossModel, levelModel);
    }

    public void removeCandle(LevelModel levelModel, int counter) {
        levelModel.getCandleModels().remove(counter);
    }
}

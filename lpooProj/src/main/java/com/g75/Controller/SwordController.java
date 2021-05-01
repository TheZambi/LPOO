package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.ArenaView;
import com.g75.View.Sprite;

import java.util.HashMap;
import java.util.List;

public class SwordController {
    HashMap<Integer, Position> offSetHashMap;
    public SwordController(){
        offSetHashMap = new HashMap<>();
        offSetHashMap.put(0, new Position(26,5));
        offSetHashMap.put(1, new Position(-25,5));
        offSetHashMap.put(2, new Position(10,-13));
        offSetHashMap.put(3, new Position(10,15));

    }

    public void update(LinkModel linkModel, LevelModel levelModel, ArenaView arenaView, LevelController levelController) {

        linkModel.getSword().setPosition(linkModel.getPosition().add(offSetHashMap.get(linkModel.getOrientation())));

        List<EnemyModel> testingEnemiesList = levelModel.getEnemies();
        Sprite swordSprite = arenaView.getLinkView().getSwordView().getSprite(linkModel.getOrientation());

        int i = 0;
        while(i<testingEnemiesList.size()){
            if (tookDamage(linkModel.getSword().getPosition(),swordSprite,arenaView.getHashMap().get(testingEnemiesList.get(i).getTableID()).getSprite(), testingEnemiesList.get(i)))
            {
                levelController.removeEnemy(i, levelModel);
            } else
                i++;
        }
        if (levelModel.getBosses() != null)
            if (hitBoss(linkModel.getSword().getPosition(), swordSprite, arenaView.getLevelView().getModelToBossViewTable().get(levelModel.getBosses().getId()).getSprite(), levelModel.getBosses()))
                levelController.bossGotHit(levelModel.getBosses(),levelModel);


    }

    public boolean tookDamage(Position swordPos, Sprite swordSprite, Sprite enemySprite, EnemyModel enemyModel){
        return swordPos.onTop(enemyModel.getPosition(), enemySprite, swordSprite);
    }

    public boolean hitBoss(Position swordPos, Sprite swordSprite, Sprite enemySprite, BossModel bossModel){
        return swordPos.onTop(bossModel.getPosition(), enemySprite, swordSprite);
    }
}

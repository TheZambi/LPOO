package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;
import com.g75.View.Sprite;

public class BatEnemyController implements EnemyController{

    public BatEnemyController(){}


    @Override
    public void update(EnemyModel enemy, LinkModel linkModel, LevelView levelView, LevelModel levelModel) {
        {
            Position newPos;
            Position oldPos;
            oldPos = enemy.getPosition();
            newPos = enemy.getMoveStrategy().getNextMove(oldPos, linkModel.getPosition());

            if(canMoveEnemy(newPos,levelView,levelView.getEnemyViewTable().get(enemy.getTableID()).getSprite(),levelModel))
                enemy.setPosition(newPos);
            enemy.setOrientation(newPos, oldPos);

        }
    }

    public boolean canMoveEnemy(Position newPosition,LevelView levelView, Sprite enemySprite, LevelModel levelModel) {
        return true;
    }

}

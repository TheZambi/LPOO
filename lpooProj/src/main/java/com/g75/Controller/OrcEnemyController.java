package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;
import com.g75.View.ObstacleView;
import com.g75.View.Sprite;

import java.util.HashMap;
import java.util.List;

public class OrcEnemyController implements EnemyController{
    @Override
    public void update(EnemyModel enemy, LinkModel linkModel, LevelView levelView, LevelModel levelModel) {
        {
            Position newPos;
            Position oldPos;
            oldPos = enemy.getPosition();
            newPos = enemy.getMoveStrategy().getNextMove(oldPos, linkModel.getPosition());
            if (canMoveEnemy(newPos, levelView, levelView.getEnemyViewTable().get(enemy.getTableID()).getSprite(), levelModel))
                enemy.setPosition(newPos);
            enemy.setOrientation(oldPos, newPos);

        }
    }

    public boolean canMoveEnemy(Position newPosition,LevelView levelView, Sprite enemySprite, LevelModel levelModel) {
        if (newPosition.x <= 0)
            return false;
        if (newPosition.y <= 0)
            return false;
        if (newPosition.x + enemySprite.width >= 400)
            return false;
        if (newPosition.y + enemySprite.height >= 161)
            return false;
        List<ObstacleModel> testingObstacleList = levelModel.getObstacles();
        List<MovableStoneModel> testingStoneList = levelModel.getStoneModels();
        HashMap<Integer, ObstacleView> obstacleTable = levelView.getObstacleViewTable();
        for (ObstacleModel obstacleModel : testingObstacleList) {
            if (newPosition.onTop(obstacleModel.getPosition(), obstacleTable.get(obstacleModel.getTableID()).getSprite(), enemySprite)) {
                return false;
            }
        }
        for (MovableStoneModel msm : testingStoneList) {
            if (newPosition.onTop(msm.getPosition(), levelView.getStoneView().getSprite(), enemySprite)) {
                return false;
            }
        }
        return true;
    }

}

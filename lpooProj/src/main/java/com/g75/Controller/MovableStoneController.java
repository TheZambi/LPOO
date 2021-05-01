package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.ArenaView;
import com.g75.Model.Position;
import com.g75.View.LevelView;

public class MovableStoneController {

    public void moveStone(MovableStoneModel stone, LevelModel levelModel, ArenaView arenaView, Integer orientation){
        Position newPosition = new Position(0,0);
        switch (orientation){
            case(0):
                newPosition = stone.getPosition().right(3);
                break;
            case(1):
                newPosition = stone.getPosition().left(3);
                break;
            case(2):
                newPosition = stone.getPosition().up(2);
                break;
            case(3):
                newPosition = stone.getPosition().down(2);
                break;
        }

        if(canMoveStone(newPosition,levelModel,arenaView, stone))
            stone.setPosition(newPosition);

    }

    public boolean canMoveStone(Position newPosition, LevelModel levelModel, ArenaView arenaView, MovableStoneModel stoneModel){


        LevelView levelView = arenaView.getLevelView();
        if(newPosition.x <= 0)
            return false;
        if(newPosition.y <= 0)
            return false;
        if(newPosition.x + levelView.getStoneView().getSprite().width >= 400)
            return false;
        if(newPosition.y + levelView.getStoneView().getSprite().height >= 161)
            return false;
        for(ObstacleModel obs:levelModel.getObstacles()){
            if(newPosition.onTop(obs.getPosition(),levelView.getObstacleViewTable().get(obs.getTableID()).getSprite(),levelView.getStoneView().getSprite()))
                return false;
        }
        for(EnemyModel em: levelModel.getEnemies())
            if(newPosition.onTop(em.getPosition(),levelView.getEnemyViewTable().get(em.getTableID()).getSprite(),levelView.getStoneView().getSprite()))
                return false;
        for(MovableStoneModel stone: levelModel.getStoneModels()){
            if(newPosition.onTop(stone.getPosition(),levelView.getStoneView().getSprite(),levelView.getStoneView().getSprite()))
                if(stoneModel != stone) {
                    return false;
                }
        }

        return true;
    }
}

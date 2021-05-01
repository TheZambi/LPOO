package com.g75.Controller;

import com.g75.Model.EnemyModel;
import com.g75.Model.LevelModel;
import com.g75.Model.LinkModel;
import com.g75.Model.Position;
import com.g75.View.LevelView;
import com.g75.View.Sprite;

public interface EnemyController
{
    void update(EnemyModel enemy, LinkModel linkModel, LevelView levelView, LevelModel levelModel);

    boolean canMoveEnemy(Position newPosition,LevelView levelView, Sprite enemySprite, LevelModel levelModel);
}

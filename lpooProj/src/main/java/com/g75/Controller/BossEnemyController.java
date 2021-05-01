package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;
import com.g75.View.Sprite;

public interface BossEnemyController {
    void update(BossModel boss, LinkModel linkModel, LevelView levelView, LevelModel levelModel);
    void hitReaction(BossModel bossModel, LevelModel levelModel);
}

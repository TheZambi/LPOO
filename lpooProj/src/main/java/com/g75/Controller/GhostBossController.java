package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;
import com.g75.View.Sprite;

public class GhostBossController implements BossEnemyController{

    public void updateInvulnerability(BossModel boss)
    {
        int invul = boss.getInvulnerability();
        if(invul > 0)
            boss.setInvulnerability(invul-1);
    }

    public boolean canMoveBoss(Position newPosition, Sprite sprite)
    {
        if (newPosition.x <= 0)
            return false;
        if (newPosition.y <= 0)
            return false;
        if (newPosition.x + sprite.width >= 400)
            return false;
        if (newPosition.y + sprite.height >= 161)
            return false;
        return true;
    }

    public void update(BossModel boss, LinkModel linkModel, LevelView levelView, LevelModel levelModel) {
        {
            Position newPos;
            Position oldPos;
            oldPos = boss.getPosition();
            newPos = boss.getMoveStrategy().getNextMove(oldPos, linkModel.getPosition(),boss.getInvulnerability());
            updateInvulnerability(boss);
            if(this.canMoveBoss(newPos, levelView.getModelToBossViewTable().get(boss.getId()).getSprite()))
                boss.setPosition(newPos);
            boss.setBossOrientation(oldPos, newPos);

        }
    }

    @Override
    public void hitReaction(BossModel bossModel, LevelModel levelModel) {
        if(levelModel.getCandleModels().size() == 0){
            levelModel.setBoss(null);
            for(StairModel sm:levelModel.getStairModels()){
                sm.setIsActive(1);
            }
        }
        bossModel.setInvulnerability(10);
    }
}

package com.g75.Controller;

import com.g75.Model.*;
import com.g75.View.LevelView;
import com.g75.View.Sprite;
import java.util.Random;

import static java.lang.Math.abs;

public class WizardBossController implements BossEnemyController{

    int spawnTimer=0;

    public void update(BossModel boss, LinkModel linkModel, LevelView levelView, LevelModel levelModel) {
        {
            this.spawnTimer--;
            if(this.spawnTimer <= 0){
                int x = linkModel.getPosition().x, y=linkModel.getPosition().y;
                while(abs(x-linkModel.getPosition().x)<52 && abs(y-linkModel.getPosition().y)<30)
                {
                    Random rand = new Random();
                    x = rand.nextInt(350);
                    y = rand.nextInt(130);
                }

                levelModel.addEnemy(new OrcEnemyModel(new Position(x,y)));
                this.spawnTimer = 20;
            }

        }
    }

    @Override
    public void hitReaction(BossModel bossModel, LevelModel levelModel) {
        switch (bossModel.getHP()){
            case 3:
            {
                bossModel.setHP(2);
                bossModel.setBossOrientation(new Position(0,0), new Position(0,0));
                bossModel.setPosition(new Position(170,125));
                break;
            }
            case 2:
            {
                bossModel.setHP(1);
                bossModel.setBossOrientation(new Position(0,0), new Position(0,0));
                bossModel.setPosition(new Position(2,20));
                break;
            }
            case 1:
            {
                levelModel.setBoss(null);
                break;
            }
        }

    }
}

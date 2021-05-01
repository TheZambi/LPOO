package com.g75.View;

import com.g75.Model.BossModel;
import com.g75.Model.GhostBossModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class WizardBossView implements BossView{
    List<Sprite> sprite = new ArrayList<>();

    public WizardBossView()
    {
        this.sprite.add(new Sprite("wizardBoss/wizardBossRight"));
        this.sprite.add(new Sprite("wizardBoss/wizardBossLeft"));
        this.sprite.add(new Sprite("wizardBoss/wizardBossUp"));
    }


    public void draw(BossModel bossModel, TextGraphics graphics){
        for(int i = 0; i < sprite.get(bossModel.getBossOrientation()).width;i++){
            for(int j = 0; j< sprite.get(bossModel.getBossOrientation()).height;j++){
                if(sprite.get(bossModel.getBossOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.get(bossModel.getBossOrientation()).background[i][j]));

                if(sprite.get(bossModel.getBossOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.get(bossModel.getBossOrientation()).foreground[i][j]));

                if(sprite.get(bossModel.getBossOrientation()).unicodeChar[i][j] != null && sprite.get(bossModel.getBossOrientation()).background[i][j] != null)
                    graphics.putString(bossModel.getPosition().x+i,bossModel.getPosition().y+j,sprite.get(bossModel.getBossOrientation()).unicodeChar[i][j]);
            }
        }
    }

    public void clear(BossModel bossModel, MapView mapView, TextGraphics graphics)
    {
        for(int i = 0; i < sprite.get(bossModel.getBossOrientation()).width;i++){
            for(int j = 0; j< sprite.get(bossModel.getBossOrientation()).height;j++){
                graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[bossModel.getPosition().x+i][bossModel.getPosition().y+j]));
                graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[bossModel.getPosition().x+i][bossModel.getPosition().y+j]));
                graphics.putString(bossModel.getPosition().x+i,bossModel.getPosition().y+j,mapView.getSprite().unicodeChar[bossModel.getPosition().x+i][bossModel.getPosition().y+j]);
            }
        }
    }

    public Sprite getSprite() {
        return sprite.get(0);
    }

}

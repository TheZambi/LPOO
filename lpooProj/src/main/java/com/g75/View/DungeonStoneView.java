package com.g75.View;

import com.g75.Model.ObstacleModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DungeonStoneView implements ObstacleView{
    Sprite sprite;

    public DungeonStoneView()
    {
        this.sprite = new Sprite("dungeonStone/DungeonStone");
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void draw(TextGraphics graphics, ObstacleModel obstacleModel){
        for(int i = 0; i < sprite.width;i++){
            for(int j = 0; j< sprite.height;j++){
                if(sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if(sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if(sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(obstacleModel.getPosition().x + i,obstacleModel.getPosition().y + j,sprite.unicodeChar[i][j]);
            }
        }
    }
}

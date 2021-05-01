package com.g75.View;

import com.g75.Model.MovableStoneModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MovableStoneView{
    Sprite sprite;

    public MovableStoneView()
    {
        this.sprite = new Sprite("movableStone/movableStone");
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void draw(TextGraphics graphics, MovableStoneModel stoneModel){
        for(int i = 0; i < sprite.width;i++){
            for(int j = 0; j< sprite.height;j++){
                if(sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if(sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if(sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(stoneModel.getPosition().x + i,stoneModel.getPosition().y + j,sprite.unicodeChar[i][j]);
            }
        }
    }

    public void clear(MovableStoneModel stoneModel, MapView mapView, TextGraphics graphics) {


        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[stoneModel.getPosition().x + i][stoneModel.getPosition().y + j]));

                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[stoneModel.getPosition().x + i][stoneModel.getPosition().y + j]));

                    graphics.putString(stoneModel.getPosition().x + i, stoneModel.getPosition().y + j, mapView.getSprite().unicodeChar[stoneModel.getPosition().x + i][stoneModel.getPosition().y + j]);

            }
        }


    }


}

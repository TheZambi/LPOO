package com.g75.View;

import com.g75.Model.CarpetModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class CarpetView {
    List<Sprite> sprites = new ArrayList<>();

    public CarpetView()
    {
        this.sprites.add(new Sprite("carpet/carpet"));
        this.sprites.add(new Sprite("carpet2/carpet2"));

    }

    public Sprite getSprite() {
        return sprites.get(0);
    }

    public void draw(TextGraphics graphics, CarpetModel carpetModel){
        Sprite sprite = sprites.get(carpetModel.getIsLocked());
        for(int i = 0; i < sprite.width;i++){
            for(int j = 0; j< sprite.height;j++){
                if(sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if(sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if(sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(carpetModel.getPosition().x + i,carpetModel.getPosition().y + j,sprite.unicodeChar[i][j]);
            }
        }
    }
}

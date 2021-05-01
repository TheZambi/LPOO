package com.g75.View;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class MapView {
    Sprite sprite;


    public MapView(int map){
        String path = "maps/map";
        path += map + "/";
        path += "map" + map;
        sprite = new Sprite(path);
    }

    public void draw(TextGraphics graphics) {
        for(int i = 0; i < sprite.width;i++){
            for(int j = 0; j< sprite.height;j++){
                if(sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if(sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if(sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(i,j,sprite.unicodeChar[i][j]);
            }
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

}

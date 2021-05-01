package com.g75.View;

import com.g75.Model.EnemyModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class BatEnemyView implements EnemyView{
    List<Sprite> sprite = new ArrayList<>();

    public BatEnemyView() {
        this.sprite.add(new Sprite("bat/bat"));
    }

    public void draw(TextGraphics graphics, EnemyModel enemy) {
        for (int i = 0; i < sprite.get(0).width; i++) {
            for (int j = 0; j < sprite.get(0).height; j++) {
                if (sprite.get(0).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.get(0).background[i][j]));

                if (sprite.get(0).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.get(0).foreground[i][j]));

                if (sprite.get(0).unicodeChar[i][j] != null && sprite.get(0).background[i][j] != null)
                    graphics.putString(enemy.getPosition().x + i, enemy.getPosition().y + j, sprite.get(0).unicodeChar[i][j]);
            }
        }
    }

    public void clear(EnemyModel enemy, MapView mapView, TextGraphics graphics) {


            for (int i = 0; i < sprite.get(0).width; i++) {
                for (int j = 0; j < sprite.get(0).height; j++) {
                    if (sprite.get(0).background[i][j] != null)
                        graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[enemy.getPosition().x + i][enemy.getPosition().y + j]));

                    if (sprite.get(0).foreground[i][j] != null)
                        graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[enemy.getPosition().x + i][enemy.getPosition().y + j]));

                    if (mapView.getSprite().unicodeChar[enemy.getPosition().x + i][enemy.getPosition().y + j] != null && sprite.get(0).background[i][j] != null)
                        graphics.putString(enemy.getPosition().x + i, enemy.getPosition().y + j, mapView.getSprite().unicodeChar[enemy.getPosition().x + i][enemy.getPosition().y + j]);

                }
            }


    }

    public Sprite getSprite() {
        return sprite.get(0);
    }

}

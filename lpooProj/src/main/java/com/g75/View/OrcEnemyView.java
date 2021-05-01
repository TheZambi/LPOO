package com.g75.View;

import com.g75.Model.EnemyModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class OrcEnemyView implements EnemyView{
    List<Sprite> sprite = new ArrayList<>();

    public OrcEnemyView() {
        this.sprite.add(new Sprite("orcEnemy/orcEnemyRight"));
        this.sprite.add(new Sprite("orcEnemy/orcEnemyLeft"));
        this.sprite.add(new Sprite("orcEnemy/orcEnemyUp"));
        this.sprite.add(new Sprite("orcEnemy/orcEnemyDown"));
    }

    public void draw(TextGraphics graphics, EnemyModel enemy) {
        for (int i = 0; i < sprite.get(enemy.getOrientation()).width; i++) {
            for (int j = 0; j < sprite.get(enemy.getOrientation()).height; j++) {
                if (sprite.get(enemy.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.get(enemy.getOrientation()).background[i][j]));

                if (sprite.get(enemy.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.get(enemy.getOrientation()).foreground[i][j]));

                if (sprite.get(enemy.getOrientation()).unicodeChar[i][j] != null && sprite.get(enemy.getOrientation()).background[i][j] != null)
                    graphics.putString(enemy.getPosition().x + i, enemy.getPosition().y + j, sprite.get(enemy.getOrientation()).unicodeChar[i][j]);
            }
        }
    }

    public void clear(EnemyModel enemy, MapView mapView, TextGraphics graphics) {

        for (int i = 0; i < sprite.get(enemy.getOrientation()).width; i++) {
            for (int j = 0; j < sprite.get(enemy.getOrientation()).height; j++) {
                if (sprite.get(enemy.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[enemy.getPosition().x + i][enemy.getPosition().y + j]));

                if (sprite.get(enemy.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[enemy.getPosition().x + i][enemy.getPosition().y + j]));

                if (mapView.getSprite().unicodeChar[enemy.getPosition().x + i][enemy.getPosition().y + j] != null && sprite.get(enemy.getOrientation()).background[i][j] != null)
                    graphics.putString(enemy.getPosition().x + i, enemy.getPosition().y + j, mapView.getSprite().unicodeChar[enemy.getPosition().x + i][enemy.getPosition().y + j]);

            }
        }


    }

    public Sprite getSprite() {
        return sprite.get(0);
    }

}

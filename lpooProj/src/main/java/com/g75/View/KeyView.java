package com.g75.View;

import com.g75.Model.KeyModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class KeyView {
    Sprite sprite;

    KeyView() {
        this.sprite = new Sprite("key/key");
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void draw(int nKeys, TextGraphics graphics) {

        for(int k=0; k<nKeys; k++) {
            for (int i = 0; i < sprite.width; i++) {
                for (int j = 0; j < sprite.height; j++) {
                    if (sprite.background[i][j] != null)
                        graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                    if (sprite.foreground[i][j] != null)
                        graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                    if (sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                        graphics.putString(409 + i, 138 + j - k * 22, sprite.unicodeChar[i][j]);

                }
            }
        }
    }

    public void clear(int nKeys, TextGraphics graphics) {

        for (int k = 0; k < nKeys; k++) {
            for (int i = 0; i < sprite.width; i++) {
                for (int j = 0; j < sprite.height; j++) {
                    graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                    graphics.putString(409 + i, 138 + j - k * 22, " ");

                }
            }
        }
    }

    public void draw(KeyModel key, TextGraphics graphics) {

        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if (sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(key.getPosition().x + i, key.getPosition().y + j, sprite.unicodeChar[i][j]);

            }
        }

    }

    public void clear(KeyModel key, MapView mapView, TextGraphics graphics) {

        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[key.getPosition().x + i][key.getPosition().y + j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[key.getPosition().x + i][key.getPosition().y + j]));

                if (mapView.getSprite().unicodeChar[key.getPosition().x + i][key.getPosition().y + j] != null && sprite.background[i][j] != null)
                    graphics.putString(key.getPosition().x + i, key.getPosition().y + j, mapView.getSprite().unicodeChar[key.getPosition().x + i][key.getPosition().y + j]);

            }
        }
    }
}

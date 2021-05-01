package com.g75.View;

import com.g75.Model.LinkModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeartView {
    Sprite sprite;

    HeartView() {
        this.sprite = new Sprite("heart/heart");
    }

    public void draw(LinkModel linkModel, TextGraphics graphics) {

        for (int k = 0; k < linkModel.getHP(); k++) {
            for (int i = 0; i < sprite.width; i++) {
                for (int j = 0; j < sprite.height; j++) {
                    if (sprite.background[i][j] != null)
                        graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                    if (sprite.foreground[i][j] != null)
                        graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                    if (sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                        graphics.putString(405 + i, k * 15 + j, sprite.unicodeChar[i][j]);

                }
            }
        }
    }

    public void clear(LinkModel linkModel, TextGraphics graphics) {

        for (int k = 0; k < linkModel.getHP(); k++) {
            for (int i = 0; i < sprite.width; i++) {
                for (int j = 0; j < sprite.height; j++) {
                    graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                    graphics.putString(405 + i, k * 15 + j, " ");

                }
            }
        }
    }
}


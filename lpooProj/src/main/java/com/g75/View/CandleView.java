package com.g75.View;

import com.g75.Model.CandleModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class CandleView {

    Sprite sprite;

    CandleView() {
        this.sprite = new Sprite("candle/candle");
    }

    public Sprite getSprite() {
        return sprite;
    }
    public void clear(CandleModel candle, TextGraphics graphics, MapView mapView) {

        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[candle.getPosition().x + i][candle.getPosition().y + j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[candle.getPosition().x + i][candle.getPosition().y + j]));

                if (mapView.getSprite().unicodeChar[candle.getPosition().x + i][candle.getPosition().y + j] != null && sprite.background[i][j] != null)
                    graphics.putString(candle.getPosition().x + i, candle.getPosition().y + j, mapView.getSprite().unicodeChar[candle.getPosition().x + i][candle.getPosition().y + j]);

            }
        }
    }

    public void draw(CandleModel candle, TextGraphics graphics) {

        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if (sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(candle.getPosition().x + i, candle.getPosition().y + j, sprite.unicodeChar[i][j]);

            }
        }
    }
}

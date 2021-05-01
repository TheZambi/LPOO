package com.g75.View;

import com.g75.Model.PopUpModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PopUpView {
    Sprite sprite;

    PopUpView() {
        this.sprite = new Sprite("popup/popup");
    }

    public void draw(PopUpModel popUpModel, TextGraphics graphics) {

        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.background[i][j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.foreground[i][j]));

                if (sprite.unicodeChar[i][j] != null && sprite.background[i][j] != null)
                    graphics.putString(popUpModel.getPosition().x + i, popUpModel.getPosition().y + j, sprite.unicodeChar[i][j]);

            }
        }

    }

    public void clear(PopUpModel popUpModel, MapView mapView, TextGraphics graphics) {
        for (int i = 0; i < sprite.width; i++) {
            for (int j = 0; j < sprite.height; j++) {
                if (sprite.background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[popUpModel.getPosition().x + i][popUpModel.getPosition().y + j]));

                if (sprite.foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[popUpModel.getPosition().x + i][popUpModel.getPosition().y + j]));

                if (mapView.getSprite().unicodeChar[popUpModel.getPosition().x + i][popUpModel.getPosition().y + j] != null && sprite.background[i][j] != null)
                    graphics.putString(popUpModel.getPosition().x + i, popUpModel.getPosition().y + j, mapView.getSprite().unicodeChar[popUpModel.getPosition().x + i][popUpModel.getPosition().y + j]);

            }
        }
    }

}

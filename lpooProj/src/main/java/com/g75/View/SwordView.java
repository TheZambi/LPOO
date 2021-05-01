package com.g75.View;

import com.g75.Model.LinkModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class SwordView {
    List<Sprite> sprite = new ArrayList<>();

    SwordView() {
        this.sprite.add(new Sprite("sword/swordRight"));
        this.sprite.add(new Sprite("sword/swordLeft"));
        this.sprite.add(new Sprite("sword/swordUp"));
        this.sprite.add(new Sprite("sword/swordDown"));
    }

    public Sprite getSprite(int orientation) {
        return sprite.get(orientation);
    }

    public void draw(LinkModel link, TextGraphics graphics) {

        for (int i = 0; i < sprite.get(link.getOrientation()).width; i++) {
            for (int j = 0; j < sprite.get(link.getOrientation()).height; j++) {
                if(link.getSword().getPosition().x +i >= 400)
                    continue;
                if(link.getSword().getPosition().x +i < 0)
                    continue;
                if(link.getSword().getPosition().y +j >= 161)
                    continue;
                if(link.getSword().getPosition().y + j < 0)
                    continue;
                if (sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.get(link.getOrientation()).background[i][j]));

                if (sprite.get(link.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.get(link.getOrientation()).foreground[i][j]));

                if (sprite.get(link.getOrientation()).unicodeChar[i][j] != null && sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.putString(link.getSword().getPosition().x + i, link.getSword().getPosition().y + j, sprite.get(link.getOrientation()).unicodeChar[i][j]);

            }
        }
    }

    public void clear(LinkModel link, MapView mapView, TextGraphics graphics) {

        for (int i = 0; i < sprite.get(link.getOrientation()).width; i++) {
            for (int j = 0; j < sprite.get(link.getOrientation()).height; j++) {
                if(link.getSword().getPosition().x +i >= 400)
                    continue;
                if(link.getSword().getPosition().x +i < 0)
                    continue;
                if(link.getSword().getPosition().y +j >= 161)
                    continue;
                if(link.getSword().getPosition().y + j < 0)
                    continue;
                if (sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[link.getSword().getPosition().x + i][link.getSword().getPosition().y + j]));

                if (sprite.get(link.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[link.getSword().getPosition().x + i][link.getSword().getPosition().y + j]));

                if (mapView.getSprite().unicodeChar[link.getSword().getPosition().x + i][link.getSword().getPosition().y + j] != null && sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.putString(link.getSword().getPosition().x + i, link.getSword().getPosition().y + j, mapView.getSprite().unicodeChar[link.getSword().getPosition().x + i][link.getSword().getPosition().y + j]);

            }
        }
    }
}

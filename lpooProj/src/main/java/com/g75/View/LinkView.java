package com.g75.View;

import com.g75.Model.LinkModel;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class LinkView {
    List<Sprite> sprite = new ArrayList<>();
    SwordView swordView;

    public LinkView()
    {
        this.sprite.add(new Sprite("link/linkRight"));
        this.sprite.add(new Sprite("link/linkLeft"));
        this.sprite.add(new Sprite("link/linkUp"));
        this.sprite.add(new Sprite("link/linkDown"));
        this.swordView = new SwordView();
    }
    public void draw(LinkModel link, TextGraphics graphics){
        for(int i = 0; i < sprite.get(link.getOrientation()).width;i++){
            for(int j = 0; j< sprite.get(link.getOrientation()).height;j++){
                if(sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(sprite.get(link.getOrientation()).background[i][j]));

                if(sprite.get(link.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(sprite.get(link.getOrientation()).foreground[i][j]));

                if(sprite.get(link.getOrientation()).unicodeChar[i][j] != null && sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.putString(link.getPosition().x+i,link.getPosition().y+j,sprite.get(link.getOrientation()).unicodeChar[i][j]);
            }
        }
        if(link.isAttacking())
            swordView.draw(link, graphics);
    }
    public void clear(LinkModel link, MapView mapView, TextGraphics graphics)
    {
        for(int i = 0; i < sprite.get(link.getOrientation()).width;i++){
            for(int j = 0; j< sprite.get(link.getOrientation()).height;j++){
                if(sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.setBackgroundColor(TextColor.Factory.fromString(mapView.getSprite().background[link.getPosition().x+i][link.getPosition().y+j]));

                if(sprite.get(link.getOrientation()).foreground[i][j] != null)
                    graphics.setForegroundColor(TextColor.Factory.fromString(mapView.getSprite().foreground[link.getPosition().x+i][link.getPosition().y+j]));

                if(mapView.getSprite().unicodeChar[link.getPosition().x+i][link.getPosition().y+j] != null && sprite.get(link.getOrientation()).background[i][j] != null)
                    graphics.putString(link.getPosition().x+i,link.getPosition().y+j,mapView.getSprite().unicodeChar[link.getPosition().x+i][link.getPosition().y+j]);

            }
        }
        if(link.isAttacking())
            swordView.clear(link, mapView, graphics);
    }

    public Sprite getSprite() {
        return sprite.get(0);
    }

    public SwordView getSwordView() {
        return swordView;
    }
}

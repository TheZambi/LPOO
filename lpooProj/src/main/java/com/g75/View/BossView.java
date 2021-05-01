package com.g75.View;

import com.g75.Model.BossModel;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface BossView {

    Sprite getSprite();
    void clear(BossModel bossModel, MapView mapView, TextGraphics graphics);
    void draw(BossModel bossModel, TextGraphics graphics);
}


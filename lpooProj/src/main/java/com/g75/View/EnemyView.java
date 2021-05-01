package com.g75.View;

import com.g75.Model.EnemyModel;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface EnemyView {
    Sprite getSprite();
    void draw(TextGraphics graphics, EnemyModel enemy);
    void clear(EnemyModel enemy, MapView mapView, TextGraphics graphics);
}

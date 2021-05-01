package com.g75.View;

import com.g75.Model.ObstacleModel;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface ObstacleView {
    Sprite getSprite();
    void draw(TextGraphics graphics, ObstacleModel obstacleModel);
}

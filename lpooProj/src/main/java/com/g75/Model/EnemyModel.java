package com.g75.Model;

import com.g75.Strategies.Strategy;

public interface EnemyModel {
    Position getPosition();
    void setPosition(Position position);
    Strategy getMoveStrategy();
    void setOrientation(Position newPos, Position oldPos);
    int getOrientation();
    Integer getTableID();
}

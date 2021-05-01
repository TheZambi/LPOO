package com.g75.Strategies;

import com.g75.Model.Position;

public interface BossStrategy {
    Position getNextMove(Position oldPosition, Position linkPosition, int invulnerability);
}

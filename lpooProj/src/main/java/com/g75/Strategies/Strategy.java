package com.g75.Strategies;

import com.g75.Model.Position;

public interface Strategy {
    Position getNextMove(Position oldPosition, Position linkPosition);
}

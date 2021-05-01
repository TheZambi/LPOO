package com.g75.Strategies;

import com.g75.Model.Position;

import static java.lang.Math.abs;

public class WizardBossStrategy implements BossStrategy {
    public Position getNextMove(Position oldPosition, Position linkPosition, int invulnerability){
        return oldPosition;
    }
}

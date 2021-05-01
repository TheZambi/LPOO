package com.g75.Strategies;

import com.g75.Model.Position;

import static java.lang.Math.abs;

public class GhostBossStrategy implements BossStrategy {
    public Position getNextMove(Position oldPosition, Position linkPosition, int invulnerability){
        int mult = 1;
        if(invulnerability > 0)
            mult = -1;
        int x = linkPosition.x - oldPosition.x;
        int y = linkPosition.y - oldPosition.y;
        if(abs(x)>abs(y)){
            if(x > 0)
                return oldPosition.right(3*mult);
            else
                return oldPosition.left(3*mult);
        }
        else{
            if(y > 0)
                return oldPosition.down(2*mult);
            else
                return oldPosition.up(2*mult);
        }
    }
}

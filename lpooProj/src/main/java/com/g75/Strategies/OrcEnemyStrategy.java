package com.g75.Strategies;

import com.g75.Model.Position;

import static java.lang.Math.abs;

public class OrcEnemyStrategy implements Strategy {

    public Position getNextMove(Position oldPosition, Position linkPosition){
        int x = linkPosition.x - oldPosition.x;
        int y = linkPosition.y - oldPosition.y;
        if(abs(x)>abs(y)){
            if(x > 0)
                return oldPosition.right(2);
            else
                return oldPosition.left(2);
        }
        else{
            if(y > 0)
                return oldPosition.down(1);
            else
                return oldPosition.up(1);
        }
    }
}

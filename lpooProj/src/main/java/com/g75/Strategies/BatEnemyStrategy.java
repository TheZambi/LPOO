package com.g75.Strategies;

import com.g75.Model.Position;

import static java.lang.Math.abs;

public class BatEnemyStrategy implements Strategy {

    public Position getNextMove(Position oldPosition, Position linkPosition){

        if(abs(oldPosition.x - linkPosition.x) > 100)
            return oldPosition;
        if(abs(oldPosition.y - linkPosition.y) > 50)
            return oldPosition;
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

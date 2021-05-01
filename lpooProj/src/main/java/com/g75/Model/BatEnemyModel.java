package com.g75.Model;

import com.g75.Strategies.*;

public class BatEnemyModel implements EnemyModel, Moveable {
    Position position;
    Integer tableID;
    Strategy moveStrategy;

    public BatEnemyModel(Position position) {
        this.position = position;
        this.tableID = 1;
        this.moveStrategy = new BatEnemyStrategy();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Strategy getMoveStrategy() {
        return this.moveStrategy;
    }

    public Integer getTableID() {
        return tableID;
    }

    @Override
    public void setOrientation(Position newPos, Position oldPos){
    }
    @Override
    public int getOrientation(){
        return 0;
    }
}

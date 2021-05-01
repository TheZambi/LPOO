package com.g75.Model;

import com.g75.Strategies.OrcEnemyStrategy;
import com.g75.Strategies.Strategy;

public class OrcEnemyModel implements EnemyModel, Moveable {
    Position position;
    Orientation orientation;
    Strategy moveStrategy;
    Integer tableID;

    public OrcEnemyModel(Position position) {
        this.position = position;
        this.orientation = Orientation.RIGHT;
        this.tableID = 0;
        this.moveStrategy = new OrcEnemyStrategy();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getOrientation() {
        switch(orientation) {
            case RIGHT:
                return 0;
            case LEFT:
                return 1;
            case UP:
                return 2;
            case DOWN:
                return 3;

        }
        return 0;
    }

    public void setOrientation(Position oldPosition, Position newPosition) {
        if(oldPosition.x > newPosition.x)
            this.orientation = Orientation.LEFT;
        if(oldPosition.x < newPosition.x)
            this.orientation = Orientation.RIGHT;
        if(oldPosition.y > newPosition.y)
            this.orientation = Orientation.UP;
        if(oldPosition.y < newPosition.y)
            this.orientation = Orientation.DOWN;

    }

    public Strategy getMoveStrategy() {
        return moveStrategy;
    }

    public Integer getTableID() {
        return tableID;
    }
}

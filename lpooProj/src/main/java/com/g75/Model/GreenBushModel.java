package com.g75.Model;

public class GreenBushModel implements ObstacleModel {
    private Position position;
    Integer tableID;

    public GreenBushModel(Position position){
        this.position = position;
        this.tableID = 0;
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
    public Integer getTableID() {
        return tableID;
    }
}
package com.g75.Model;

public class DungeonStoneModel implements ObstacleModel
{
    private Position position;
    Integer tableID;
    public DungeonStoneModel(Position position){
        this.position = position;
        this.tableID = 1;
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

package com.g75.Model;

public class MovableStoneModel implements Moveable {
    private Position position;

    public MovableStoneModel(Position position){
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }


}
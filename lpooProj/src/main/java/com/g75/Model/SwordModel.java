package com.g75.Model;

public class SwordModel {
    Position position;

    SwordModel(Position position){
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}

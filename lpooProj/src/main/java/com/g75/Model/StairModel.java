package com.g75.Model;


public class StairModel {
    Position position;
    int nextMap;
    int isActive = 0;

    public StairModel(Position position, int nextMap)
    {
        this.position = position;
        this.nextMap = nextMap;
    }

    public Position getPosition() {
        return position;
    }

    public int getIsActive() {
        return isActive;
    }

    public int getNextMap() {
        return nextMap;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

}


package com.g75.Model;


public class CarpetModel {
    Position position;
    int nextLevel;
    int isLocked;

    public CarpetModel(Position position, int nextLevel, int lock)
    {
        this.position = position;
        this.nextLevel = nextLevel;
        this.isLocked = lock;
    }

    public Position getPosition() {
        return position;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void unlock()
    {
        this.isLocked=0;
    }
}

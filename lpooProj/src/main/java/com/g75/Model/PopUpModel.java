package com.g75.Model;

public class PopUpModel {
    Position position;
    int popUpTime = 0;
    public PopUpModel(Position position) {
        this.position = position;

    }

    public Position getPosition() {
        return position;
    }

    public int getPopUpTime() {
        return popUpTime;
    }

    public void setPopUpTime(int popUpTime) {
        this.popUpTime = popUpTime;
    }
}

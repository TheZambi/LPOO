package com.aor.refactoring.example5;

public class Turtle {
    Position pos;

    public Turtle(int row, int column, char direction) {
        this.pos = new Position(row,column,direction);
    }

    public int getRow() {
        return pos.getRow();
    }

    public int getColumn() {
        return pos.getColumn();
    }

    public char getDirection() {
        return pos.getDirection();
    }

    public void execute(char command) {
        if (command == 'L') { // ROTATE LEFT
            pos.rotateLeft();
        } else if (command == 'R') { // ROTATE RIGHT
            pos.rotateRight();
        } else if (command == 'F'){ // MOVE FORWARD
            pos.move();
        }
    }
}

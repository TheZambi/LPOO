package com.aor.refactoring.example5;

public class Position {
    private int row;
    private int column;
    private char direction;


    public Position(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void rotateLeft()
    {
        switch (direction) {
            case 'N': direction=('W');break;
            case 'W': direction=('S');break;
            case 'S': direction=('E');break;
            case 'E': direction=('N');break;
        }
    }

    public void rotateRight()
    {
        switch (direction) {
            case 'N': direction='E';break;
            case 'E': direction='S';break;
            case 'S': direction='W';break;
            case 'W': direction='N';break;
        }
    }

    public void move()
    {
        switch (direction)
        {
            case 'N': row--;break;
            case 'S': row++;break;
            case 'W': column--;break;
            case 'E': column++;
        }
    }
}

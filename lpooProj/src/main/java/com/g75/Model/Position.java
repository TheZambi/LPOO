package com.g75.Model;

import com.g75.View.Sprite;

import static java.lang.Math.abs;

public class Position {
    public Integer x, y;
    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Position left(int speed) {
        return new Position(x - speed, y);
    }

    public Position right(int speed) {
        return new Position(x + speed, y);
    }

    public Position up(int speed) {
        return new Position(x, y - speed);
    }

    public Position down(int speed) {
        return new Position(x, y + speed);
    }

    public boolean onTop(Position testingPosition, Sprite testingPositionSprite, Sprite newPositionSprite) {
        if(abs(testingPosition.x - this.x) > 60)
            return false;
        if(abs(testingPosition.y - this.y) > 36)
            return false;

        if (testingPosition.x <= this.x &&
                testingPosition.x + testingPositionSprite.width >= this.x) {
            if (testingPosition.y <= this.y &&
                    testingPosition.y + testingPositionSprite.height >= this.y) {
                return true;
            }
            if (testingPosition.y <= this.y + newPositionSprite.height &&
                    testingPosition.y + testingPositionSprite.height >= this.y + newPositionSprite.height) {
                return true;
            }
            if(testingPosition.y >= this.y &&
                    testingPosition.y + testingPositionSprite.height <= this.y+newPositionSprite.height)
                return true;
        }
        if (testingPosition.x <= this.x + newPositionSprite.width &&
                testingPosition.x + testingPositionSprite.width >= this.x + newPositionSprite.width) {
            if (testingPosition.y <= this.y &&
                    testingPosition.y + testingPositionSprite.height >= this.y) {
                return true;
            }
            if (testingPosition.y <= this.y + newPositionSprite.height
                    && testingPosition.y + testingPositionSprite.height >= this.y + newPositionSprite.height) {
                return true;

            }
            if(testingPosition.y >= this.y &&
                    testingPosition.y + testingPositionSprite.height <= this.y+newPositionSprite.height)
                return true;
        }
        if (testingPosition.x >= this.x &&
                testingPosition.x + testingPositionSprite.width <= this.x + newPositionSprite.width) {
            if (testingPosition.y <= this.y &&
                    testingPosition.y + testingPositionSprite.height >= this.y) {
                return true;
            }
            if (testingPosition.y <= this.y + newPositionSprite.height &&
                    testingPosition.y + testingPositionSprite.height >= this.y + newPositionSprite.height) {
                return true;
            }
            if(testingPosition.y >= this.y &&
                    testingPosition.y + testingPositionSprite.height <= this.y+newPositionSprite.height)
                return true;
        }
        return false;
    }

    public Position add(Position position) {
        return new Position(this.x+position.x,this.y+position.y);
    }

    public boolean fullyOnTop(Position objectPos ,Sprite objectSprite,Sprite linkSprite){
        if (objectPos.x <= this.x &&
                objectPos.x + objectSprite.width >= this.x + linkSprite.width) {
            if(objectPos.y <= this.y &&
                    objectPos.y + objectSprite.height >= this.y + linkSprite.height)
                return true;
        }
        return false;
    }

}

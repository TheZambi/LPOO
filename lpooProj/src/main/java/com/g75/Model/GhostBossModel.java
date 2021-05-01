package com.g75.Model;

import com.g75.Strategies.BossStrategy;
import com.g75.Strategies.GhostBossStrategy;

enum BossOrientation
{
    RIGHT,
    LEFT,
    UPRIGHT,
    UPLEFT
}

public class GhostBossModel implements Moveable,BossModel {
    Position position;
    BossOrientation orientation;
    BossStrategy moveStrategy;
    int invulnerability = 0;
    Integer id = 0;
    boolean up = false;
    boolean right = true;
    public GhostBossModel(Position position) {
        this.position = position;
        this.orientation = BossOrientation.RIGHT;
        this.moveStrategy = new GhostBossStrategy();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getBossOrientation() {
        switch (orientation) {
            case RIGHT:
                return 0;
            case LEFT:
                return 1;
            case UPRIGHT:
                return 2;
            case UPLEFT:
                return 3;
        }
        return 0;
    }

    public void setBossOrientation(Position oldPosition, Position newPosition) {
        if(oldPosition.y > newPosition.y)
            up = true;
        else if(oldPosition.y < newPosition.y)
            up = false;
        if(oldPosition.x > newPosition.x)
            right = false;
        else if(oldPosition.x < newPosition.x)
            right = true;
        if(right){
            if(up)
                this.orientation = BossOrientation.UPRIGHT;
            else
                this.orientation = BossOrientation.RIGHT;
        }
        else {
            if(up)
                this.orientation = BossOrientation.UPLEFT;
            else
                this.orientation = BossOrientation.LEFT;
        }
    }

    public BossStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setInvulnerability(int invulnerability) {
        this.invulnerability = invulnerability;
    }

    public int getInvulnerability() {
        return invulnerability;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Integer getHP() {
        return 0;
    }

    @Override
    public void setHP(int hp) {
    }
}

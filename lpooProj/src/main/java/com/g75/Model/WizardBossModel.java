package com.g75.Model;

import com.g75.Strategies.BossStrategy;
import com.g75.Strategies.WizardBossStrategy;

public class WizardBossModel implements Moveable, BossModel {
    Position position;
    BossOrientation orientation;
    BossStrategy moveStrategy;
    int invulnerability = 0;
    Integer id = 1;
    Integer hp = 3;

    public WizardBossModel() {
        this.position = new Position(0, 0);
        this.orientation = BossOrientation.RIGHT;
        this.moveStrategy = new WizardBossStrategy();
    }

    public WizardBossModel(Position position) {
        this.position = position;
        this.orientation = BossOrientation.RIGHT;
        this.moveStrategy = new WizardBossStrategy();
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

        }
        return 0;
    }

    public void setBossOrientation(Position oldPosition, Position newPosition) {
        switch(this.hp) {
            case 1:
                this.orientation = BossOrientation.RIGHT;
                break;
            case 2:
                this.orientation = BossOrientation.UPRIGHT;
                break;
            case 3:
                this.orientation = BossOrientation.LEFT;
                break;
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
        return hp;

    }

    @Override
    public void setHP(int hp) {
        this.hp=hp;
    }
}

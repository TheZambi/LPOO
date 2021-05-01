package com.g75.Model;

import com.g75.Commands.*;

enum Orientation {RIGHT,LEFT,UP,DOWN}

public class LinkModel implements Moveable {
    private Position position;
    private Orientation orientation = Orientation.RIGHT;
    private int HP;
    private int invulnerability = 0;
    private int attackTimer = 0;
    private boolean attacking;
    private boolean changeLevel;
    private SwordModel sword;
    private int nKeys = 0;

    public LinkModel(){
        this.position = new Position(0,0);
        this.sword = new SwordModel(position);
        this.HP = 3;
        this.attacking = false;
    }
    public LinkModel(Position position) {
        this.position = position;
        this.sword = new SwordModel(position);
        this.HP = 3;
        this.attacking = false;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getOrientation() {
        switch(orientation) {
            case RIGHT:
                return 0;
            case LEFT:
                return 1;
            case UP:
                return 2;
            case DOWN:
                return 3;

        }
        return 0;
    }

    public void setOrientation(Command command) {
        if(command instanceof CommandDown)
            this.orientation = Orientation.DOWN;
        else if(command instanceof CommandUp)
            this.orientation = Orientation.UP;
        else if(command instanceof CommandRight)
            this.orientation = Orientation.RIGHT;
        else if(command instanceof CommandLeft)
            this.orientation = Orientation.LEFT;
    }

    public void setHP(int i) {
        this.HP=i;
    }

    public int getHP() {
        return this.HP;
    }

    public void setKeys(int nKeys) {
        this.nKeys = nKeys;
    }

    public int getKeys() {
        return nKeys;
    }

    public int getInvulnerability() {
        return invulnerability;
    }

    public void setInvulnerability(int invulnerability) {
        this.invulnerability = invulnerability;
    }

    public boolean isAttacking() {
        return this.attacking;
    }

    public void attack() {
        this.attacking = true;
        this.attackTimer = 30;
    }

    public int getAttackTime() {
        return this.attackTimer;
    }

    public void setAttackTimer(int attackTimer) {
        this.attackTimer = attackTimer;
    }

    public void stopAttacking() {
        this.attacking=false;
    }

    public SwordModel getSword() {
        return sword;
    }

    public void changeLevel() {
        this.changeLevel = true;
    }

    public boolean isChangeLevel() {
        return changeLevel;
    }

    public void stopChangeLevel() {
        this.changeLevel = false;
    }
}

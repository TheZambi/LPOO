package com.g75.Model;

import com.g75.Strategies.BossStrategy;
import com.g75.Strategies.GhostBossStrategy;

public interface BossModel {

    Position getPosition();
    void setPosition(Position position);

    int getBossOrientation();

    void setBossOrientation(Position oldPosition, Position newPosition);

    BossStrategy getMoveStrategy();

    void setInvulnerability(int invulnerability);

    int getInvulnerability();

    Integer getId();

    Integer getHP();

    void setHP(int hp);
}

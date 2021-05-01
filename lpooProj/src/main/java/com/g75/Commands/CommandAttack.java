package com.g75.Commands;

import com.g75.Model.LinkModel;
import com.g75.Model.Position;

public class CommandAttack implements Command {

    @Override
    public Position execute(LinkModel link) {
        link.attack();
        return link.getPosition();
    }
}

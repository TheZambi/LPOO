package com.g75.Commands;

import com.g75.Model.LinkModel;
import com.g75.Model.Position;

public class CommandLevel implements Command{

    @Override
    public Position execute(LinkModel link) {
        link.changeLevel();
        return link.getPosition();
    }
}

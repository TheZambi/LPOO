package com.g75.Commands;

import com.g75.Model.LinkModel;
import com.g75.Model.Position;

public class CommandQuit implements Command {
    public Position execute(LinkModel link) {
        return new Position(0,0);
    }
}

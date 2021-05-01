package com.g75.Commands;

import com.g75.Model.LinkModel;
import com.g75.Model.Position;

public class CommandRight implements Command{


    public Position execute(LinkModel link) {
        return link.getPosition().right(4);
    }
}

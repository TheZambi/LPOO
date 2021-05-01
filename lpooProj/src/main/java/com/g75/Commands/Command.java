package com.g75.Commands;
import com.g75.Model.*;

public interface Command {
    Position execute(LinkModel link);
}

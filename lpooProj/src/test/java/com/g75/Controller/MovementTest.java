package com.g75.Controller;

import com.g75.Commands.*;
import com.g75.Model.LinkModel;
import com.g75.Model.Position;
import org.junit.Test;


import static org.junit.Assert.*;

public class MovementTest {


    @Test
    public void moveSide() {
        LinkModel elem = new LinkModel (new Position(10,20));

        CommandRight cmdr = new CommandRight();
        CommandLeft cmdl = new CommandLeft();

        elem.setPosition(cmdr.execute(elem));

        Integer testerX = 14;
        Integer testerY = 20;

        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);

        elem.setPosition(cmdr.execute(elem));
        elem.setPosition(cmdr.execute(elem));
        testerX = 22;
        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);

        for(int i=0 ; i<4;i++)
            elem.setPosition(cmdl.execute(elem));

        testerX = 6;

        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);
    }

    @Test
    public void moveVertically() {
        LinkModel elem = new LinkModel (new Position(10,20));

        CommandUp cmdu = new CommandUp();
        CommandDown cmdd = new CommandDown();

        elem.setPosition(cmdd.execute(elem));

        Integer testerX = 10;
        Integer testerY = 22;
        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);
        elem.setPosition(cmdd.execute(elem));
        elem.setPosition(cmdd.execute(elem));
        testerY = 26;
        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);

        for(int i=0 ; i<4;i++)
            elem.setPosition(cmdu.execute(elem));

        testerY = 18;

        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);
    }

    @Test
    public void move() {
        LinkModel elem = new LinkModel (new Position(10,20));

        CommandRight cmdr = new CommandRight();
        CommandLeft cmdl = new CommandLeft();
        CommandUp cmdu = new CommandUp();
        CommandDown cmdd = new CommandDown();

        elem.setPosition(cmdl.execute(elem));
        elem.setPosition(cmdl.execute(elem));

        elem.setPosition(cmdd.execute(elem));
        elem.setPosition(cmdd.execute(elem));
        elem.setPosition(cmdd.execute(elem));

        elem.setPosition(cmdl.execute(elem));

        elem.setPosition(cmdr.execute(elem));
        elem.setPosition(cmdr.execute(elem));
        elem.setPosition(cmdr.execute(elem));
        elem.setPosition(cmdr.execute(elem));
        elem.setPosition(cmdr.execute(elem));

        elem.setPosition(cmdu.execute(elem));


        Integer testerX = 18;
        Integer testerY = 24;
        assertEquals(testerX,elem.getPosition().x);
        assertEquals(testerY,elem.getPosition().y);

    }



}

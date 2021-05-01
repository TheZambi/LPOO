package com.g75.Controller;

import com.g75.Model.CarpetModel;
import com.g75.Model.Position;
import com.g75.View.Sprite;
import org.junit.Test;


import static org.junit.Assert.*;

public class CarpetTests {
    @Test
    public void testFullyOnTop(){
        Sprite link = new Sprite("link/linkRight");
        Sprite carpet = new Sprite("carpet/carpet");
        Position linkPos = new Position(100,200);
        Position carpetPos = new Position(99,199);

        assertTrue(linkPos.fullyOnTop(carpetPos,carpet,link));

        linkPos = new Position(0,0);

        assertFalse(linkPos.fullyOnTop(carpetPos,carpet,link));
    }
    @Test
    public void testCarpetMovingToOtherLevel(){
        CarpetModel carpet = new CarpetModel(new Position(100,100),1,1);

        assertEquals(1,carpet.getNextLevel());

        assertEquals(1,carpet.getIsLocked());
        carpet.unlock();
        assertEquals(0,carpet.getIsLocked());
    }

}

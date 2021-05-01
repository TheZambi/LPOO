package com.g75.Commands;

import com.g75.Commands.*;
import com.g75.Model.LinkModel;
import com.g75.Model.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CommandsTest {

    @Test
    public void AttackTest() {
        LinkModel linkModel = new LinkModel();
        CommandAttack cmd = new CommandAttack();
        assertEquals(false, linkModel.isAttacking());
        Position aux = cmd.execute(linkModel);
        assertNotNull(aux);
        assertEquals(true, linkModel.isAttacking());
    }

    @Test
    public void LevelTest() {
        LinkModel linkModel = new LinkModel();
        CommandLevel cmd = new CommandLevel();
        assertEquals(false, linkModel.isChangeLevel());
        Position aux = cmd.execute(linkModel);
        assertNotNull(aux);
        assertEquals(true, linkModel.isChangeLevel());
    }
    @Test
    public void NoChangesCommandTest(){
        LinkModel linkModel = new LinkModel();
        CommandQuit cmd = new CommandQuit();
        DoNothingCommand cmd1 = new DoNothingCommand();

        linkModel.setPosition(new Position(50,50));
        Integer testX = 50,testY = 50;

        Position aux = cmd.execute(linkModel);
        assertNotNull(aux);
        assertEquals(linkModel.getPosition().x,testX);
        assertEquals(linkModel.getPosition().y,testY);

        aux = cmd1.execute(linkModel);
        assertNotNull(aux);
        assertEquals(linkModel.getPosition().x,testX);
        assertEquals(linkModel.getPosition().y,testY);
    }


}

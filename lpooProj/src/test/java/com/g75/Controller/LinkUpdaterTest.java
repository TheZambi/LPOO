package com.g75.Controller;

import com.g75.Commands.Command;
import com.g75.Commands.CommandDown;
import com.g75.Commands.CommandLeft;
import com.g75.Commands.CommandUp;
import com.g75.Controller.ArenaController;
import com.g75.Controller.LevelController;
import com.g75.Controller.LinkController;
import com.g75.Model.*;
import com.g75.View.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.assertEquals;



public class LinkUpdaterTest {
    @Test
    public  void linkGotHit(){
        List<EnemyModel> testingList = new ArrayList<>();
        Position newPosition = new Position(50,50);
        LinkModel linkModel = new LinkModel();
        LevelView levelView = new LevelView();
        HashMap<Integer,EnemyView> map = levelView.getEnemyViewTable();
        LinkController controller = new LinkController();
        LinkView linkView = new LinkView();
        Sprite linkSprite = linkView.getSprite();
        controller.checkForDamage(testingList,linkModel,newPosition,map,linkSprite);

        assertEquals(3, linkModel.getHP());
        assertEquals(0,linkModel.getInvulnerability());

        testingList.add(new OrcEnemyModel(new Position(50,50)));
        controller.checkForDamage(testingList,linkModel,newPosition,map,linkSprite);


        assertEquals(2, linkModel.getHP());
        assertEquals(60,linkModel.getInvulnerability());

    }
    @Test
    public void testOneUpdateCycle() throws IOException {
        ArenaModel arenaModel = new ArenaModel();
        ArenaView arenaView = new ArenaView();
        ArenaController arenaController = new ArenaController();
        arenaModel.initMaps(arenaView);
        arenaModel.setLevel(2);
        arenaModel.setMap(0);

        arenaModel.getLinkModel().setPosition(new Position(180,145));

        Integer realX = arenaModel.getLinkModel().getPosition().x;
        Integer realY = arenaModel.getLinkModel().getPosition().y-2;
        Integer orcX = arenaModel.getEnemies().get(0).getPosition().x;
        Integer orcY = arenaModel.getEnemies().get(0).getPosition().y+1;

        Integer batX = arenaModel.getEnemies().get(1).getPosition().x;
        Integer batY = arenaModel.getEnemies().get(1).getPosition().y;

        arenaController.updateLink(arenaModel,new CommandUp(),arenaView);
        arenaController.updateEnemies(arenaModel,arenaView);

        assertEquals(realX,arenaModel.getLinkModel().getPosition().x);
        assertEquals(realY,arenaModel.getLinkModel().getPosition().y);

        assertEquals(orcX,arenaModel.getEnemies().get(0).getPosition().x);
        assertEquals(orcY,arenaModel.getEnemies().get(0).getPosition().y);

        assertEquals(batX,arenaModel.getEnemies().get(1).getPosition().x);
        assertEquals(batY,arenaModel.getEnemies().get(1).getPosition().y);

    }

}

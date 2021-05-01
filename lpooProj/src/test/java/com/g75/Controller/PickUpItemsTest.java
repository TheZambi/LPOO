package com.g75.Controller;

import com.g75.Commands.*;
import com.g75.Controller.LevelController;
import com.g75.Controller.LinkController;
import com.g75.Model.*;
import org.junit.Test;


import static org.junit.Assert.*;

public class PickUpItemsTest {
    @Test
    public void PickUpCandle()
    {
        LevelController levelController = new LevelController();
        LevelModel levelModel = new LevelModel();
        int index=0;
        LinkController linkController = new LinkController();
        levelModel.addCandle(new CandleModel(new Position(100, 100)));

        assertEquals(1,levelModel.getCandleModels().size());

        linkController.pickUpCandle(levelController,levelModel,index);

        assertEquals(0,levelModel.getCandleModels().size());
    }

    @Test
    public void PickUpKey()
    {
        LinkModel linkModel = new LinkModel();
        LevelController levelController = new LevelController();
        LevelModel levelModel = new LevelModel();
        int index=0;
        LinkController linkController = new LinkController();
        levelModel.addKey(new KeyModel(new Position(100, 100)));

        assertEquals(0,linkModel.getKeys());
        assertEquals(1,levelModel.getKeys().size());

        linkController.pickUpKey(levelController,levelModel,linkModel,index);

        assertEquals(0,levelModel.getKeys().size());
        assertEquals(1,linkModel.getKeys());

    }
}

package com.g75.Controller;

import com.g75.Controller.LinkController;
import com.g75.Model.*;
import com.g75.Strategies.BatEnemyStrategy;
import com.g75.View.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CollisionTests {
    @Test
    public void collideWithBush() {
        LinkModel elem = new LinkModel(new Position(10, 20));
        LinkView linkView = new LinkView();
        GreenBushModel bushModel = new GreenBushModel(new Position(12, 20));
        GreenBushView greenBushView = new GreenBushView();

        boolean test = elem.getPosition().onTop(bushModel.getPosition(), greenBushView.getSprite(), linkView.getSprite());
        assertEquals(true, test);

        bushModel.setPosition(new Position(100,100));
        test = elem.getPosition().onTop(bushModel.getPosition(), greenBushView.getSprite(), linkView.getSprite());
        assertEquals(false, test);
    }

    @Test
    public void collideWithEnemy() {
        LinkModel elem = new LinkModel(new Position(10, 20));
        LinkView linkView = new LinkView();
        OrcEnemyView orcEnemyView = new OrcEnemyView();
        LinkController linkController = new LinkController();

        List<OrcEnemyModel> testList = new ArrayList<>();
        testList.add(new OrcEnemyModel(new Position(20,20)));
        testList.add(new OrcEnemyModel(new Position(100,100)));
        testList.add(new OrcEnemyModel(new Position(200,200)));

        assertEquals(3,testList.size());
        boolean test = false;
        for(OrcEnemyModel oem : testList){
            test = linkController.linkGotHit(elem.getPosition(),orcEnemyView.getSprite(),linkView.getSprite(),oem);
            if(test)
                break;
        }
        assertEquals(true, test);

        testList.get(0).setPosition(new Position(300,300));
        for(OrcEnemyModel oem : testList){
            test = linkController.linkGotHit(elem.getPosition(),orcEnemyView.getSprite(),linkView.getSprite(),oem);
            if(test)
                break;
        }
        assertEquals(false, test);

        testList.get(0).setPosition(new Position(10,20+ linkView.getSprite().height));
        for(OrcEnemyModel oem : testList){
            test = linkController.linkGotHit(elem.getPosition(),orcEnemyView.getSprite(),linkView.getSprite(),oem);
            if(test)
                break;
        }
        assertEquals(true, test);
    }

    @Test
    public void canMoveHeroTest() {
        LinkModel elem = new LinkModel(new Position(10, 20));
        LinkView linkView = new LinkView();
        GreenBushView greenBushView = new GreenBushView();
        LinkController linkController = new LinkController();

        HashMap<Integer, ObstacleView> testHash = new HashMap<>();
        testHash.put(0, greenBushView);

        List<ObstacleModel> testList = new ArrayList<>();
        testList.add(new GreenBushModel(new Position(12, 20)));

        assertEquals(1,testList.size());

        boolean test = linkController.canMoveHero(elem.getPosition(),testHash,linkView.getSprite(),testList);
        assertEquals(false, test);

    }

}

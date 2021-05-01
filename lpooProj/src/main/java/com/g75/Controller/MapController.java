package com.g75.Controller;

import com.g75.Model.LinkModel;
import com.g75.Model.MapModel;
import com.g75.View.LevelView;


public class MapController {
    LevelController levelController;

    public MapController(){
        this.levelController = new LevelController();
    }

    public void update(LinkModel linkModel, MapModel mapModel, LevelView levelView) {
        this.levelController.update(linkModel,mapModel.getLevelModels().get(mapModel.getLevel()), levelView);
    }

    public LevelController getLevelController() {
        return levelController;
    }


}

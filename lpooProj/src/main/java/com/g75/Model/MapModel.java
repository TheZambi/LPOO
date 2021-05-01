package com.g75.Model;


import java.util.ArrayList;
import java.util.List;

public class MapModel {
    List<LevelModel> levelModels;
    int level;
    public MapModel(){
        this.levelModels = new ArrayList<>();
        this.level = 0;
    }

    public int getLevel() {
        return level;
    }

    public void addLevel(){
        levelModels.add(new LevelModel());
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<LevelModel> getLevelModels() {
        return levelModels;
    }
}

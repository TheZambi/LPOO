package com.g75.View;

import com.g75.Model.*;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.HashMap;

public class LevelView {
    HashMap<Integer, ObstacleView> modelToObstacleViewTable;
    HashMap<Integer, EnemyView> modelToEnemyViewTable;

    HashMap<Integer, BossView> modelToBossViewTable;
    CarpetView carpetView;
    MovableStoneView stoneView;
    KeyView keyView;
    StairView stairView;
    CandleView candleView;

    public LevelView()
    {
        GreenBushView greenBushView = new GreenBushView();
        OrcEnemyView orcEnemyView = new OrcEnemyView();
        BatEnemyView batEnemyView = new BatEnemyView();
        GhostBossView ghostBossView = new GhostBossView();
        DungeonStoneView dungeonStoneView = new DungeonStoneView();
        WizardBossView wizardBossView = new WizardBossView();
        modelToEnemyViewTable = new HashMap<>();
        modelToObstacleViewTable = new HashMap<>();
        modelToBossViewTable = new HashMap<>();
        modelToBossViewTable.put(0,ghostBossView);
        modelToBossViewTable.put(1,wizardBossView);
        modelToEnemyViewTable.put(0, orcEnemyView);
        modelToEnemyViewTable.put(1, batEnemyView);
        modelToObstacleViewTable.put(0, greenBushView);
        modelToObstacleViewTable.put(1, dungeonStoneView);

        this.carpetView = new CarpetView();
        this.stoneView = new MovableStoneView();
        this.keyView = new KeyView();
        this.stairView = new StairView();
        this.candleView = new CandleView();

    }

    public HashMap<Integer, ObstacleView> getObstacleViewTable() {
        return modelToObstacleViewTable;
    }

    public void draw(TextGraphics graphics, LevelModel levelModel){

        for(int i=0;i<levelModel.getCarpetModels().size();i++)
            carpetView.draw(graphics,levelModel.getCarpetModels().get(i));

        for(int i=0;i<levelModel.getKeys().size();i++)
            keyView.draw(levelModel.getKeys().get(i),graphics);

        for(int i = 0;i<levelModel.getStoneModels().size();i++)
            stoneView.draw(graphics,levelModel.getStoneModels().get(i));

        for(int i=0;i<levelModel.getObstacles().size();i++)
            modelToObstacleViewTable.get(levelModel.getObstacles().get(i).getTableID()).draw(graphics,levelModel.getObstacles().get(i));

        for(int i=0;i<levelModel.getEnemies().size();i++)
            modelToEnemyViewTable.get(levelModel.getEnemies().get(i).getTableID()).draw(graphics,levelModel.getEnemies().get(i));


            if(levelModel.getBosses() != null)
                modelToBossViewTable.get(levelModel.getBosses().getId()).draw(levelModel.getBosses(),graphics);



        for(int i=0;i<levelModel.getStairModels().size();i++)
        {
            stairView.draw(graphics,levelModel.getStairModels().get(i));
        }

        for(int i = 0;i<levelModel.getCandleModels().size();i++){
            candleView.draw(levelModel.getCandleModels().get(i),graphics);
        }
    }

    public CandleView getCandleView() {
        return candleView;
    }

    public HashMap<Integer, EnemyView> getEnemyViewTable() {
        return modelToEnemyViewTable;
    }

    public void clear(LevelModel levelModel, MapView mapView, TextGraphics graphics) {
        for(EnemyModel em : levelModel.getEnemies())
            modelToEnemyViewTable.get(em.getTableID()).clear(em,mapView,graphics);
        for(MovableStoneModel st: levelModel.getStoneModels()){
            stoneView.clear(st,mapView,graphics);
        }
        for(KeyModel k:levelModel.getKeys()){
            keyView.clear(k,mapView,graphics);
        }
        for(int i = 0;i<levelModel.getCandleModels().size();i++){
            candleView.clear(levelModel.getCandleModels().get(i),graphics, mapView);
        }
            if(levelModel.getBosses() != null)
                modelToBossViewTable.get(levelModel.getBosses().getId()).clear(levelModel.getBosses(),mapView,graphics);

    }

    public CarpetView getCarpetView() {
        return this.carpetView;
    }

    public MovableStoneView getStoneView() {
        return stoneView;
    }

    public KeyView getKeyView() {
        return keyView;
    }


    public StairView getStairView() {
        return stairView;
    }

    public HashMap<Integer, BossView> getModelToBossViewTable() {
        return modelToBossViewTable;
    }
}

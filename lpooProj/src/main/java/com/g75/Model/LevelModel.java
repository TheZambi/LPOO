package com.g75.Model;


import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    List<ObstacleModel> obstacles;
    List<EnemyModel> enemies;
    BossModel bosses;
    List<CarpetModel> carpetModels;
    List<CandleModel> candleModels;

    List<StairModel> stairModels;
    List<MovableStoneModel> stoneModels;
    List<KeyModel> keys;
    PopUpModel popUpModel = new PopUpModel(new Position(100,66));

    public LevelModel(){
        obstacles = new ArrayList<>();
        enemies = new ArrayList<>();
        carpetModels = new ArrayList<>();
        stoneModels = new ArrayList<>();
        stairModels = new ArrayList<>();
        keys = new ArrayList<>();
        candleModels = new ArrayList<>();
        bosses = null;
    }

    public List<CandleModel> getCandleModels() {
        return candleModels;
    }

    public void setBoss(BossModel bosses){
        this.bosses = bosses;
    }

    public void addCandle(CandleModel candleModel){this.candleModels.add(candleModel);}

    public List<KeyModel> getKeys() {
        return keys;
    }

    public List<MovableStoneModel> getStoneModels() {
        return stoneModels;
    }

    public void addStone(MovableStoneModel movableStoneModel){
        this.stoneModels.add(movableStoneModel);
    }

    public void addObstacle(ObstacleModel obstacleModel){
        obstacles.add(obstacleModel);
    }

    public List<ObstacleModel> getObstacles() {
        return obstacles;
    }

    public List<EnemyModel> getEnemies() {
        return enemies;
    }

    public void addEnemy(EnemyModel enemyModel){
        enemies.add(enemyModel);
    }

    public void addKey(KeyModel keyModel){
        keys.add(keyModel);
    }

    public List<CarpetModel> getCarpetModels() {
        return carpetModels;
    }

    public void addCarpet(CarpetModel carpetModel) {this.carpetModels.add(carpetModel);}

    public PopUpModel getPopUpModel() {
        return popUpModel;
    }

    public List<StairModel> getStairModels() { return stairModels; }

    public void addStair(StairModel stairModel) {this.stairModels.add(stairModel);}

    public BossModel getBosses() {
        return bosses;
    }

}

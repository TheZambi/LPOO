package com.g75.Model;

import com.g75.View.ArenaView;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    LinkModel linkModel;
    List<MapModel> mapModels;
    int map;

    public ArenaModel() {
        mapModels = new ArrayList<>();
        linkModel = new LinkModel();
        map = 0;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public List<MapModel> getMapModels() {
        return mapModels;
    }

    public void addMap() {
        mapModels.add(new MapModel());
    }

    public LinkModel getLinkModel() {
        return linkModel;
    }

    public int getMap() {
        return map;
    }

    public int getLevel() {
        return this.getMapModels().get(this.getMap()).getLevel();
    }

    public List<EnemyModel> getEnemies() {
        int map = this.getMap();
        int level = this.getLevel();
        return this.getMapModels().get(map).getLevelModels().get(level).getEnemies();
    }


    public void setLevel(int level) {
        this.getMapModels().get(map).setLevel(level);
    }

    public void initMaps(ArenaView arenaView) throws IOException {


        this.addMap(); //ADD NEW MAP

        arenaView.addMapView(0); // Add new background


        //ADD NEW LEVEL
        initMap0Level0(false, null);
        initMap0Level1(false, null);
        initMap0Level2(false, null);
        initMap0Level3(false, null);

        this.addMap();
        initMap1Level0(false, null);
        initMap1Level1(false, null);
        initMap1Level2(false, null);
        initMap1Level3(false, null);
        initMap1Level4(false,null);

        arenaView.addMapView(1);

        this.setMap(0);
        this.setLevel(0); //STARTING LEVEL FOR THIS MAP

        if(arenaView.screen!=null) {
            try {
                Clip clip;
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        new File("./src/main/resources/music/map0.wav"));
                clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.loop(clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            arenaView.getMapViews().get(this.getMap()).draw(arenaView.graphics); //Draw current map
            arenaView.screen.refresh();
        }
    }

    public void initMap0Level0(boolean reset, Position carpetPos) {
        if (carpetPos == null)
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }
        if (!reset)
            this.getMapModels().get(0).addLevel();
        this.getMapModels().get(0).getLevelModels().get(0).getObstacles().clear();
        this.getMapModels().get(0).getLevelModels().get(0).getEnemies().clear();
        this.getMapModels().get(0).getLevelModels().get(0).getCarpetModels().clear();


        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(0, 0)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(374, 0)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(0, 145)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(374, 145)));

        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(0, 17)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(374, 17)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(0, 128)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(374, 128)));

        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 0)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 0)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 145)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 145)));

        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 17)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 17)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 128)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 128)));

        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 54)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 54)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(60, 94)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(318, 94)));

        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(189, 35)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(189, 75)));
        this.getMapModels().get(0).getLevelModels().get(0).addObstacle(new GreenBushModel(new Position(189, 115)));

        this.getMapModels().get(0).getLevelModels().get(0).addEnemy(new OrcEnemyModel(new Position(220, 35)));
        this.getMapModels().get(0).getLevelModels().get(0).addEnemy(new OrcEnemyModel(new Position(220, 75)));
        this.getMapModels().get(0).getLevelModels().get(0).addEnemy(new OrcEnemyModel(new Position(220, 115)));


        this.getMapModels().get(0).getLevelModels().get(0).addCarpet(new CarpetModel(new Position(369, 72), 1, 0));//direita


    }

    public void initMap0Level1(boolean reset, Position carpetPos) {
        if (carpetPos == null)
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }
        if (!reset)
            this.getMapModels().get(0).addLevel();
        this.getMapModels().get(0).getLevelModels().get(1).getObstacles().clear();
        this.getMapModels().get(0).getLevelModels().get(1).getEnemies().clear();
        this.getMapModels().get(0).getLevelModels().get(1).getCarpetModels().clear();
        this.getMapModels().get(0).getLevelModels().get(1).getStoneModels().clear();


        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(0, 0)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(374, 0)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(0, 145)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(374, 145)));

        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(0, 17)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(374, 17)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(0, 128)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(374, 128)));

        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 0)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 0)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 145)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 145)));

        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 17)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 17)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 128)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 128)));

        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 54)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 54)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(60, 94)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(318, 94)));

        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(189, 35)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(189, 75)));
        this.getMapModels().get(0).getLevelModels().get(1).addObstacle(new GreenBushModel(new Position(189, 115)));


        this.getMapModels().get(0).getLevelModels().get(1).addEnemy(new BatEnemyModel(new Position(220, 35)));
        this.getMapModels().get(0).getLevelModels().get(1).addEnemy(new BatEnemyModel(new Position(220, 75)));
        this.getMapModels().get(0).getLevelModels().get(1).addEnemy(new BatEnemyModel(new Position(220, 115)));

        this.getMapModels().get(0).getLevelModels().get(1).addCarpet(new CarpetModel(new Position(0, 72), 0, 0));//esquerda
        this.getMapModels().get(0).getLevelModels().get(1).addCarpet(new CarpetModel(new Position(185, 0), 2, 0));//cima

    }

    public void initMap0Level2(boolean reset, Position carpetPos) {
        if (!reset)
            this.getMapModels().get(0).addLevel();

        this.getMapModels().get(0).getLevelModels().get(2).getObstacles().clear();
        this.getMapModels().get(0).getLevelModels().get(2).getEnemies().clear();
        this.getMapModels().get(0).getLevelModels().get(2).getStoneModels().clear();

        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(185, 143));//STARTING POSITION
            this.getMapModels().get(0).getLevelModels().get(2).addKey(new KeyModel(new Position(93, 36)));


            this.getMapModels().get(0).getLevelModels().get(2).addCarpet(new CarpetModel(new Position(185, 143), 1, 0));//baixo
            this.getMapModels().get(0).getLevelModels().get(2).addCarpet(new CarpetModel(new Position(369, 72), 3, 1));//direita
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }


        for (int i = 0; i < 9; i++) {
            this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(0, i * 18)));
        }

        for (int i = 1; i < 13; i++) {

            this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(i * 31, 0)));
        }

        this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(372, 36)));
        this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(341, 36)));

        this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(372, 108)));
        this.getMapModels().get(0).getLevelModels().get(2).addObstacle(new GreenBushModel(new Position(341, 108)));

        this.getMapModels().get(0).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(341, 90)));
        this.getMapModels().get(0).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(341, 72)));
        this.getMapModels().get(0).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(341, 54)));

        this.getMapModels().get(0).getLevelModels().get(2).addEnemy(new OrcEnemyModel(new Position(200, 50)));
        this.getMapModels().get(0).getLevelModels().get(2).addEnemy(new BatEnemyModel(new Position(93, 36)));

    }

    public void initMap0Level3(boolean reset, Position carpetPos) {
        if (!reset)
            this.getMapModels().get(0).addLevel();

        this.getMapModels().get(0).getLevelModels().get(3).getObstacles().clear();
        this.getMapModels().get(0).getLevelModels().get(3).getEnemies().clear();
        this.getMapModels().get(0).getLevelModels().get(3).getStoneModels().clear();

        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(10, 72));//STARTING POSITION
            this.getMapModels().get(0).getLevelModels().get(3).setBoss(new GhostBossModel(new Position(200, 120)));//

            this.getMapModels().get(0).getLevelModels().get(3).addCandle(new CandleModel(new Position(360, 20)));
            this.getMapModels().get(0).getLevelModels().get(3).addCandle(new CandleModel(new Position(30, 20)));
            this.getMapModels().get(0).getLevelModels().get(3).addCandle(new CandleModel(new Position(360, 126)));
            this.getMapModels().get(0).getLevelModels().get(3).addCandle(new CandleModel(new Position(30, 126)));
            this.getMapModels().get(0).getLevelModels().get(3).addCarpet(new CarpetModel(new Position(0, 72), 2, 0));//direita
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        for (int i = 1; i < 13; i++) {

            this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(i * 31, 0)));
            this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(i * 31, 146)));
        }
        for (int i = 0; i < 9; i++) {
            if (i != 4)
                this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(0, i * 18)));
            this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(374, i * 18)));
        }

        for (int i = 1; i < 5; i++) {
            this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(i * 31, 54)));
            this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(374 - i * 31, 54)));
        }

        this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(124, 36)));
        this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(217, 18)));
        this.getMapModels().get(0).getLevelModels().get(3).addStone(new MovableStoneModel(new Position(217, 36)));
        this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(248, 72)));
        this.getMapModels().get(0).getLevelModels().get(3).addObstacle(new GreenBushModel(new Position(248, 90)));

        this.getMapModels().get(0).getLevelModels().get(3).addStair(new StairModel(new Position(343, 72), 1));
    }

    public void initMap1Level0(boolean reset, Position carpetPos) {
        if (!reset) {
            this.getMapModels().get(1).addLevel();
            this.getMapModels().get(1).getLevelModels().get(0).addKey(new KeyModel(new Position(150, 58)));
            this.getMapModels().get(1).getLevelModels().get(0).addCarpet(new CarpetModel(new Position(218, 58), 2, 0));//direita
            this.getMapModels().get(1).getLevelModels().get(0).addCarpet(new CarpetModel(new Position(369, 72), 1, 0));//direita
        }
        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        this.getMapModels().get(1).getLevelModels().get(0).getObstacles().clear();
        this.getMapModels().get(1).getLevelModels().get(0).getEnemies().clear();

        for (int i = 5; i < 11; i++) {
            this.getMapModels().get(1).getLevelModels().get(0).addObstacle(new DungeonStoneModel(new Position(i * 25, 44)));
            this.getMapModels().get(1).getLevelModels().get(0).addObstacle(new DungeonStoneModel(new Position(i * 25, 102)));
        }

        for (int i = 4; i < 7; i++) {
            this.getMapModels().get(1).getLevelModels().get(0).addObstacle(new DungeonStoneModel(new Position(125, i * 16 - 7)));
            this.getMapModels().get(1).getLevelModels().get(0).addObstacle(new DungeonStoneModel(new Position(250, i * 16 - 7)));
        }

        this.getMapModels().get(1).getLevelModels().get(0).addEnemy(new OrcEnemyModel(new Position(185, 20)));
        this.getMapModels().get(1).getLevelModels().get(0).addEnemy(new OrcEnemyModel(new Position(185, 130)));


    }

    public void initMap1Level1(boolean reset, Position carpetPos) {
        if (!reset) {
            this.getMapModels().get(1).addLevel();
            this.getMapModels().get(1).getLevelModels().get(1).addCarpet(new CarpetModel(new Position(0, 72), 0, 0));//direita
            this.getMapModels().get(1).getLevelModels().get(1).addCarpet(new CarpetModel(new Position(369, 72), 2, 0));//direita
        }
        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        this.getMapModels().get(1).getLevelModels().get(1).getObstacles().clear();
        this.getMapModels().get(1).getLevelModels().get(1).getEnemies().clear();
        this.getMapModels().get(1).getLevelModels().get(1).getStoneModels().clear();

        for (int i = 0; i < 9; i++) {
            this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(i * 25, 20)));
            this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(i * 25, 126)));
        }


        this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(200, 35)));
        this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(200, 111)));

        this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(226, 50)));
        this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(226, 95)));

        this.getMapModels().get(1).getLevelModels().get(1).addObstacle(new DungeonStoneModel(new Position(290, 74)));

        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(84, 55)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(84, 72)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(84, 89)));

        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(117, 107)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(117, 37)));

        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(144, 55)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(144, 72)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(144, 89)));

        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(172, 55)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(172, 89)));


        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(172, 37)));
        this.getMapModels().get(1).getLevelModels().get(1).addStone(new MovableStoneModel(new Position(172, 106)));

        this.getMapModels().get(1).getLevelModels().get(1).addEnemy(new BatEnemyModel(new Position(320, 20)));
        this.getMapModels().get(1).getLevelModels().get(1).addEnemy(new BatEnemyModel(new Position(320, 130)));
    }

    public void initMap1Level2(boolean reset, Position carpetPos) {
        if (!reset) {
            this.getMapModels().get(1).addLevel();
            this.getMapModels().get(1).getLevelModels().get(2).addCarpet(new CarpetModel(new Position(0, 72), 1, 0));//direita
            this.getMapModels().get(1).getLevelModels().get(2).addCarpet(new CarpetModel(new Position(218, 58), 0, 0));//direita
            this.getMapModels().get(1).getLevelModels().get(2).addCarpet(new CarpetModel(new Position(185, 143), 3, 0));//baixo
        }
        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(185, 1));//STARTING POSITION
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        this.getMapModels().get(1).getLevelModels().get(2).getObstacles().clear();
        this.getMapModels().get(1).getLevelModels().get(2).getEnemies().clear();
        this.getMapModels().get(1).getLevelModels().get(2).getStoneModels().clear();

        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(341, 35)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(284, 35)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(369, 52)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(314, 52)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(341, 71)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(284, 71)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(369, 89)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(314, 89)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(342, 107)));
        this.getMapModels().get(1).getLevelModels().get(2).addStone(new MovableStoneModel(new Position(284, 107)));

        for (int i = 5; i < 11; i++) {
            this.getMapModels().get(1).getLevelModels().get(2).addObstacle(new DungeonStoneModel(new Position(i * 25, 44)));
            this.getMapModels().get(1).getLevelModels().get(2).addObstacle(new DungeonStoneModel(new Position(i * 25, 106)));
        }

        for (int i = 4; i < 7; i++) {
            this.getMapModels().get(1).getLevelModels().get(2).addObstacle(new DungeonStoneModel(new Position(125, i * 16 - 7)));
            if (i != 6)
                this.getMapModels().get(1).getLevelModels().get(2).addObstacle(new DungeonStoneModel(new Position(250, i * 16 - 7)));
        }
        for (int i = 8; i < 11; i++) {
            this.getMapModels().get(1).getLevelModels().get(2).addObstacle(new DungeonStoneModel(new Position(250, i * 16 - 7)));
        }

    }

    public void initMap1Level3(boolean reset, Position carpetPos) {
        if (!reset) {
            this.getMapModels().get(1).addLevel();
        }
        if (carpetPos == null) {
            this.getMapModels().get(1).getLevelModels().get(3).addCarpet(new CarpetModel(new Position(185, 0), 2, 0));
            this.getMapModels().get(1).getLevelModels().get(3).addCarpet(new CarpetModel(new Position(369, 72), 4, 1));//direita
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        this.getMapModels().get(1).getLevelModels().get(3).getObstacles().clear();
        this.getMapModels().get(1).getLevelModels().get(3).getEnemies().clear();

        this.getMapModels().get(1).getLevelModels().get(3).addEnemy(new BatEnemyModel(new Position(350,50)));
        this.getMapModels().get(1).getLevelModels().get(3).addEnemy(new BatEnemyModel(new Position(350,98)));
        this.getMapModels().get(1).getLevelModels().get(3).addEnemy(new OrcEnemyModel(new Position(110,100)));
        this.getMapModels().get(1).getLevelModels().get(3).addEnemy(new OrcEnemyModel(new Position(250,100)));

    }

    public void initMap1Level4(boolean reset, Position carpetPos) {
        if (!reset) {
            this.getMapModels().get(1).addLevel();
            this.getMapModels().get(1).getLevelModels().get(3).addCarpet(new CarpetModel(new Position(185, 0), 2, 0));
            this.getMapModels().get(1).getLevelModels().get(3).addCarpet(new CarpetModel(new Position(369, 72), 4, 1));//direita
        }
        if (carpetPos == null) {
            this.linkModel.setPosition(new Position(28, 72));//STARTING POSITION
        } else {
            int carpX = carpetPos.x + 30, carpY = carpetPos.y + 18;
            if (400 - carpX >= 370)
                carpX = 31;
            if (400 - carpX <= 0)
                carpX = 399;
            if (161 - carpY >= 152)
                carpY = 28;
            if (161 - carpY <= 0)
                carpY = 160;

            this.linkModel.setPosition(new Position(400 - carpX, 161 - carpY));
        }

        this.getMapModels().get(1).getLevelModels().get(4).getObstacles().clear();
        this.getMapModels().get(1).getLevelModels().get(4).getEnemies().clear();

        this.getMapModels().get(1).getLevelModels().get(4).setBoss(new WizardBossModel(new Position(338,30)));
    }
}

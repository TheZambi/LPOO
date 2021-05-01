package com.g75.View;

import com.g75.Model.ArenaModel;
import com.g75.Model.PopUpModel;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ArenaView {
    public Screen screen;
    public TextGraphics graphics;
    LinkView linkView;
    LevelView levelView;
    List<MapView> mapViews;
    HeartView heartView;
    PopUpView popUpView;


    public List<MapView> getMapViews() {
        return mapViews;
    }


    public LinkView getLinkView() {
        return linkView;
    }

    public LevelView getLevelView() {
        return levelView;
    }

    public void startTerminal()throws IOException{


        Font font = new Font("Courier", Font.PLAIN, 4);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(
                true,
                AWTTerminalFontConfiguration.BoldMode.NOTHING,
                font);

        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(430, 161))
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();


        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        screen.clear();
    }
    public ArenaView(){
        linkView = new LinkView();
        mapViews = new ArrayList<>();
        levelView = new LevelView();
        heartView = new HeartView();
        popUpView = new PopUpView();
    }

    public void addMapView(int map){
        this.mapViews.add(new MapView(map));
    }

    public void clear(ArenaModel arenaModel) {
        int map = arenaModel.getMap();
        int level = arenaModel.getLevel();
        linkView.clear(arenaModel.getLinkModel(),  mapViews.get(arenaModel.getMap()), graphics);
        levelView.clear(arenaModel.getMapModels().get(map).getLevelModels().get(level), mapViews.get(arenaModel.getMap()),graphics);
        heartView.clear(arenaModel.getLinkModel(),graphics);
        levelView.getKeyView().clear(arenaModel.getLinkModel().getKeys(),graphics);

    }


    public void draw(ArenaModel arenaModel) throws IOException {
        int map = arenaModel.getMap();
        int level = arenaModel.getLevel();


        levelView.draw(graphics,arenaModel.getMapModels().get(map).getLevelModels().get(level));
        if(arenaModel.getLinkModel().getInvulnerability()%5==0) //makes link 'blink' during his invulnerability time for easier visibility
            linkView.draw(arenaModel.getLinkModel(), graphics);
        heartView.draw(arenaModel.getLinkModel(),graphics);
        levelView.getKeyView().draw(arenaModel.getLinkModel().getKeys(),graphics);

    }


    public HashMap<Integer, ObstacleView> getObstacleViewTable() {
        return this.getLevelView().getObstacleViewTable();
    }

    public HashMap<Integer, EnemyView> getHashMap() {
        return this.levelView.getEnemyViewTable();
    }

    public void clear(PopUpModel popUpModel,ArenaModel arenaModel) {
        popUpView.clear(popUpModel,mapViews.get(arenaModel.getMap()),graphics);
    }

    public void draw(PopUpModel popUpModel) {
        popUpView.draw(popUpModel,graphics);

    }


}


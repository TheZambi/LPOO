package com.g75;

import com.g75.Commands.*;
import com.g75.Controller.ArenaController;
import com.g75.Model.ArenaModel;
import com.g75.View.ArenaView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

enum GameState {START,LOOP,END,CLOSE}

public class Game {
    ArenaView arenaView;
    ArenaModel arenaModel;
    ArenaController arenaController;
    GameState gameState;

    Game(){
        this.gameState = GameState.START;
    }

    public void run()throws IOException{
        if(this.gameState == GameState.START)
            this.gameStart();
        else if(this.gameState == GameState.LOOP)
            this.gameLoop();
        else if(this.gameState == GameState.END)
            this.gameEnd();
    }

    public void gameStart() throws IOException{
        this.arenaModel = new ArenaModel();
        this.arenaController = new ArenaController();
        this.arenaView = new ArenaView();
        this.arenaView.startTerminal();
        this.arenaModel.initMaps(arenaView);

        this.gameState = GameState.LOOP;
    }

    public void gameEnd() throws IOException
    {
        arenaView.screen.close();
        this.gameState = GameState.CLOSE;
    }

    public Command getNextCommand() throws IOException{

        KeyStroke input = arenaView.screen.pollInput();
        if(input!=null) {
            if (input.getKeyType() == KeyType.Character && input.getCharacter() == 'q') return new CommandQuit();
            if (input.getKeyType() == KeyType.Character && input.getCharacter() == 'z') return new CommandLevel();
            if (input.getKeyType() == KeyType.Character && input.getCharacter() == 'x') return new CommandAttack();
            if (input.getKeyType() == KeyType.ArrowDown) return new CommandDown();
            if (input.getKeyType() == KeyType.ArrowUp) return new CommandUp();
            if (input.getKeyType() == KeyType.ArrowLeft) return new CommandLeft();
            if (input.getKeyType() == KeyType.ArrowRight) return new CommandRight();
        }

        return new DoNothingCommand();
    }


    public void gameLoop() throws IOException{
        boolean lastWasPopUp = false;
        long start = System.currentTimeMillis();
        int enemySlowEffect = 0;

        while(notFinished()) {

            long timeNow = System.currentTimeMillis();

            Command command = this.getNextCommand();

            if(timeNow>start+10) { // approximately 60 fps
                start = timeNow;

                enemySlowEffect = (enemySlowEffect+1)%3;


                if(arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel().getPopUpTime() == 0) {
                    this.arenaView.clear(arenaModel);
                    if(lastWasPopUp){
                        lastWasPopUp = false;
                        this.arenaView.clear(arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel(),arenaModel);
                    }
                    if (command instanceof CommandQuit)
                        break;
                    this.arenaController.updateLink(arenaModel, command, arenaView);
                    if (enemySlowEffect == 1) { //takes double the time to update
                        this.arenaController.updateEnemies(arenaModel, arenaView);
                    }
                    this.arenaView.draw(arenaModel);
                }
                if(arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel().getPopUpTime() != 0)
                    this.arenaController.updatePopUp(arenaModel);
                if(arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel().getPopUpTime() != 0 && !lastWasPopUp){
                    this.arenaView.draw(arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel());
                    lastWasPopUp = true;
                }
                arenaView.screen.refresh();

            }
        }
        this.gameState = GameState.END;
    }

    public boolean notFinished(){
        return this.arenaModel.getLinkModel().getHP() != 0;
    }


}

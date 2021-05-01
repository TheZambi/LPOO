package com.g75;

import java.io.IOException;


public class Application {


    public static void main(String[] args) throws IOException {
        //Creating all variables
        Game game = new Game();
        while (game.gameState != GameState.CLOSE)
             game.run();
    }
}











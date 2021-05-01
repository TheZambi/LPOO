package com.g75.View;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sprite {
    public String[][] background;
    public String[][] foreground;
    public String[][] unicodeChar;
    public Integer width;
    public Integer height;
    public String name;

    public Sprite(String name){
        this.name = name;
        ReadSpriteFromTxt(this.name);
    }

    public void ReadSpriteFromTxt(String name){
        int i = 0;
        int j = 0;
        try {
            FileReader backgroundReader = new FileReader("./src/main/resources/" + name + "Background" + ".txt");
            BufferedReader backgroundBufferedReader = new BufferedReader(backgroundReader);

            FileReader foregroundReader = new FileReader("./src/main/resources/" + name + "Foreground" + ".txt");
            BufferedReader foregroundBufferedReader = new BufferedReader(foregroundReader);

            FileReader charReader = new FileReader("./src/main/resources/" + name + "Char" + ".txt");
            BufferedReader charBufferedReader = new BufferedReader(charReader);

            String line;
            width = Integer.parseInt(backgroundBufferedReader.readLine());
            height = Integer.parseInt(backgroundBufferedReader.readLine());
            this.background = new String[width][height];
            this.foreground = new String[width][height];
            this.unicodeChar = new String[width][height];
            while ((line = backgroundBufferedReader.readLine()) != null) {
                if(line.equals("::::::::::")){
                }
                else if(line.equals("null")){
                    background[i][j] = null;
                }
                else {
                    background[i][j] = line;
                }

                line = foregroundBufferedReader.readLine();
                if(line.equals("::::::::::")){
                }
                else if(line.equals("null")){
                    foreground[i][j] = null;
                }
                else {
                    foreground[i][j] = line;
                }

                line = charBufferedReader.readLine();
                if(line.equals("::::::::::")){
                    i++;
                    j=0;
                }
                else if(line.equals("null")){
                    unicodeChar[i][j] = " ";
                    j++;
                }
                else {
                    unicodeChar[i][j] = line;
                    j++;
                }
            }
            backgroundReader.close();

            foregroundReader.close();

            charReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

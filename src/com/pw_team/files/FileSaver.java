package com.pw_team.files;

import com.pw_team.gui.GameWindow;
import com.pw_team.logics.BoardRenewal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {
    public static void save(String pathToFile){
        try(BufferedWriter out =new BufferedWriter(new FileWriter(pathToFile))) {
            out.write(GameWindow.getSize() +"\n");
            out.write(GameWindow.getWidth()+"\n");
            out.write(GameWindow.getHeight()+"\n");
            out.write(GameWindow.getSleepms()+"\n");
            int st=0;
            for(int x = 0; x < GameWindow.getWidth(); x++){
                for (int y = 0; y < GameWindow.getHeight(); y++){
                    switch (BoardRenewal.boxes[x][y].cell.getStatus()){
                        case NONE -> st=0;
                        case BORN -> st=1;
                        case LIVE -> st=2;
                        case DIED -> st=3;
                    }
                    out.write(st+"\n");
                }
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}

package com.pw_team.files;

import com.pw_team.gui.GameWindow;
import com.pw_team.model.Box;
import com.pw_team.model.Cell;
import com.pw_team.model.Status;

import java.io.*;


public class FileRecovery {
    public static void loadFile(String pathToFile){
        File file = new File(pathToFile);
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            int size = Integer.parseInt(bf.readLine());
            GameWindow.setSize(size);
            int width = Integer.parseInt(bf.readLine());
            GameWindow.setWidth(width);
            int height = Integer.parseInt(bf.readLine());
            GameWindow.setHeight(height);
            int sleepms = Integer.parseInt(bf.readLine());
            GameWindow.setSleepms(sleepms);
            GameWindow.boxes = new Box[width][height];
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    GameWindow.boxes[x][y] = new Box(x,y);
                    int st = Integer.parseInt(bf.readLine());
                    Status status = Status.NONE;
                    switch (st){
                      case 0 -> status = Status.NONE;
                      case 1, 2, 3 -> status = Status.LIVE;
                    };
                    GameWindow.boxes[x][y].cell.setStatus(status);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

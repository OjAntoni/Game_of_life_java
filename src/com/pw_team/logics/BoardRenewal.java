package com.pw_team.logics;

import com.pw_team.files.FileSaver;
import com.pw_team.gui.GameWindow;
import com.pw_team.model.Box;
import com.pw_team.model.Config;
import com.pw_team.model.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardRenewal {
    public static Box[][] boxes;
    private static final int width = GameWindow.getWidth();
    private static final int height = GameWindow.getHeight();
    private static boolean firstIt = true;
    public static int sleepms = GameWindow.getSleepms();

    public static void initBoxes(Box[][] b, JFrame gameFrame, int width, int height) {

        if(firstIt && GameWindow.getInputFilePath()!=null){
            boxes = GameWindow.boxes;
            firstIt = false;
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    gameFrame.add(boxes[x][y]);
                }
            }
        }
        else {
            boxes = new Box[width][height];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    boxes[x][y] = new Box(x, y);
                    gameFrame.add(boxes[x][y]);
                }
            }
        }
        int config_addition = Config.DEATH_BORDERS ? -1 : 0;
        for (int x = 0; x < width+config_addition; x++)
            for (int y = 0; y < height+config_addition; y++)
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++) {
                        if (GameWindow.getOption() == OptionConstants.OPTION_ONE) {
                            if (!(sx == 0 && sy == 0))
                                calculateNear(x,y,sx,sy);
                        } else {
                            if (!(sx == 0 && sy == 0) && !(Math.abs(sx) == 1 && !(Math.abs(sy) == 1)))
                                calculateNear(x,y,sx,sy);
                        }
                    }
    }

    public static void initTimer(){
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(sleepms,t1);
        timer.start();
    }

    private static class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e){
            flop = !flop;
            for (int x = 0; x < width; x++)
                for (int y = 0; y < height; y++)
                {
                    if(flop) boxes[x][y].step1();
                    else boxes[x][y].step2();
                }
        }
    }

    private static void calculateNear(int x, int y, int sx, int sy){
        if(!Config.DEATH_BORDERS)
            boxes[x][y].cell.addNear(boxes[(x + sx + width) % width][(y + sy + height) % height].cell);
        else {
            if(!(x*y==0 || x==width-1 || y==height-1)){
                boxes[x][y].cell.addNear(boxes[(x + sx + width) % width][(y + sy + height) % height].cell);
            }
        }
    }
}

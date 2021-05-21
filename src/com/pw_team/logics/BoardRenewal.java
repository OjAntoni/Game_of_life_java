package com.pw_team.logics;

import com.pw_team.model.Box;
import com.pw_team.model.Config;
import com.pw_team.model.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardRenewal {
    public static Box[][] boxes;
    public static void initBoxes(Box[][] b, JFrame gameFrame) {
        b = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++) {
                b[x][y] = new Box(x, y);
                gameFrame.add(b[x][y]);
            }
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++)
                        /*
                         * @TODO написпть разграничение по методу поиска соседей
                         * @TODO пока у нас ищатся ВСЕ соседи (т.е и по диагонали)
                         * @TODO надо добавуть условие в if что ... || !(Math.abs(sx)==1 && !(Math.abs(sy)==1)
                         */
                        if (!(sx == 0 && sy == 0))
                            b[x][y].cell.addNear(b
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
        //@TODO этот цикл просто в конкретном месте сразу же при запуске делает клетки живыми. Хз оставлять или нет
        //@TODO (конечно же убрать), но надо консультация с остальными:)
        for (int x = 10; x < 15; x++) {
            b[x][10].cell.setStatus(Status.LIVE);
            b[x][10].setColor();
        }
        boxes = b;
    }

    public static void initTimer(){
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS,t1);
        timer.start();
    }
    private static class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e){
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++)
                for (int y = 0; y < Config.HEIGHT; y++)
                {
                    if(flop) boxes[x][y].step1();
                    else boxes[x][y].step2();
                }
        }
    }
}

package com.pw_team.gui;


import com.pw_team.model.Box;
import com.pw_team.model.Config;
import com.pw_team.logics.BoardRenewal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa służąca do tworzenia graficznego pola do gry
 * i zawerająca w sobie logikę gry i zachowania się komórek
 */
public class GameWindow implements Runnable {
    JFrame gameFrame;
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        BoardRenewal.initBoxes(boxes, gameFrame);
        BoardRenewal.initTimer();
        gameFrame.setVisible(true);
    }

    /**
     * metoda initFrame() służy do stworzenia obiektu JFrame
     * i nadaniu mu bazowych, niezbędnych charakterystyk
     */
    void initFrame() {
        gameFrame = new JFrame();
        gameFrame.getContentPane().setLayout(null);
        gameFrame.setSize(Config.SIZE * Config.WIDTH + 25, Config.SIZE * Config.HEIGHT + 45);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setTitle("Game of life");
    }



}

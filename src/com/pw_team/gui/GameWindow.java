package com.pw_team.gui;


import com.pw_team.files.FileRecovery;
import com.pw_team.files.FileSaver;
import com.pw_team.logics.OptionConstants;
import com.pw_team.model.Box;
import com.pw_team.model.Config;
import com.pw_team.logics.BoardRenewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

/**
 * Klasa służąca do tworzenia graficznego pola do gry
 * i zawerająca w sobie logikę gry i zachowania się komórek
 */
public class GameWindow implements Runnable {
    JFrame gameFrame;
    public static Box[][] boxes;
    private static int size = Config.SIZE;
    private static int width = Config.WIDTH;
    private static int height = Config.HEIGHT;
    private static int sleepms = Config.SLEEPMS;
    public static String outputFilePath;
    private static String inputFilePath;
    private static int option = OptionConstants.OPTION_ONE;

    public GameWindow(String inputFilePath, String outputFilePath, int option, boolean noInputFile){
        if(noInputFile){
            inputFilePath=null;
        }
        else{
            GameWindow.inputFilePath = inputFilePath;
            FileRecovery.loadFile(inputFilePath);
            System.out.println(getInputFilePath()+" "+getSize()+" "+getWidth()+" "+getHeight());
        }
        GameWindow.outputFilePath = outputFilePath.equals("") ? "cache.txt" : outputFilePath;
        GameWindow.option = option;

    }

    @Override
    public void run() {
        initFrame();
        BoardRenewal.initTimer();
        BoardRenewal.initBoxes(boxes, gameFrame, width, height);

        gameFrame.setVisible(true);
    }

    /**
     * metoda initFrame() służy do stworzenia obiektu JFrame
     * i nadaniu mu bazowych, niezbędnych charakterystyk
     */
    void initFrame() {
        gameFrame = new JFrame();
        gameFrame.getContentPane().setLayout(null);
        gameFrame.setSize(size * width + 25, size * height + 45);
        gameFrame.addWindowListener(new WindowListener());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setTitle("Game of life");
    }



    class WindowListener implements java.awt.event.WindowListener{

        /**
         * Invoked the first time a window is made visible.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowOpened(WindowEvent e) {

        }

        /**
         * Invoked when the user attempts to close the window
         * from the window's system menu.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing window "+ sleepms);
            FileSaver.save(outputFilePath);
        }

        /**
         * Invoked when a window has been closed as the result
         * of calling dispose on the window.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowClosed(WindowEvent e) {
        }

        /**
         * Invoked when a window is changed from a normal to a
         * minimized state. For many platforms, a minimized window
         * is displayed as the icon specified in the window's
         * iconImage property.
         *
         * @param e the event to be processed
         * @see Frame#setIconImage
         */
        @Override
        public void windowIconified(WindowEvent e) {

        }

        /**
         * Invoked when a window is changed from a minimized
         * to a normal state.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        /**
         * Invoked when the Window is set to be the active Window. Only a Frame or
         * a Dialog can be the active Window. The native windowing system may
         * denote the active Window or its children with special decorations, such
         * as a highlighted title bar. The active Window is always either the
         * focused Window, or the first Frame or Dialog that is an owner of the
         * focused Window.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowActivated(WindowEvent e) {

        }

        /**
         * Invoked when a Window is no longer the active Window. Only a Frame or a
         * Dialog can be the active Window. The native windowing system may denote
         * the active Window or its children with special decorations, such as a
         * highlighted title bar. The active Window is always either the focused
         * Window, or the first Frame or Dialog that is an owner of the focused
         * Window.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowDeactivated(WindowEvent e) {

        }

    }

    public static int getSize() {
        return size;
    }

    public static int getWidth() {
        return width;
    }

    public static int getOption() {
        return option;
    }

    public static int getHeight() {
        return height;
    }

    public static int getSleepms() {
        return sleepms;
    }

    public static String getInputFilePath() {
        return inputFilePath;
    }

    public static void setSize(int size) {
        GameWindow.size = size;
    }

    public static void setWidth(int width) {
        GameWindow.width = width;
    }

    public static void setHeight(int height) {
        GameWindow.height = height;
    }

    public static void setSleepms(int sleepms) {
        GameWindow.sleepms = sleepms;
    }

    public void setOption(int option) {
        this.option = option;
    }
}

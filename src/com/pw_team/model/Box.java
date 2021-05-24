package com.pw_team.model;

import com.pw_team.gui.GameWindow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * Klasa Box jest "reprezentantem" naszej komórki
 * na JFrame w objekcie JPanel, z których składa się
 * pole do symulacji gry
 */
public class Box extends JPanel{

    public Cell cell;

    public Box (int x, int y){
        super();
        cell = new Cell();
        setBounds(x * GameWindow.getSize(),y * GameWindow.getSize(), GameWindow.getSize(), GameWindow.getSize());
        setBackground(Config.getCollor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                cell.turn();
            }
        });
    }

    public void setColor()
    {
        setBackground(Config.getCollor(cell.getStatus()));
    }

    public void step1(){
        cell.step1();
        setColor();
    }
    public void step2(){
        cell.step2();
        setColor();
    }
}

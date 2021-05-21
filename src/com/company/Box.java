package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa Box jest "reprezentantem" naszej komórki
 * na JFrame w objekcie JPanel, z których składa się
 * pole do symulacji gry
 */
public class Box extends JPanel {

    Cell cell;

    public Box (int x, int y){
        super();
        cell = new Cell();
        setBounds(x * Config.SIZE,y * Config.SIZE, Config.SIZE, Config.SIZE);
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

    void step1(){
        cell.step1();
        setColor();
    }
    void step2(){
        cell.step2();
        setColor();
    }
}

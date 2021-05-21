package com.company;

import java.awt.*;

public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 60;
    public static final int HEIGHT = 40;
    public static final int SLEEPMS = 100;

    public static Color getCollor(Status status) {
        switch (status) {
            default:
            case NONE: return Color.BLACK;
            case BORN: return Color.GRAY;
            case LIVE: return Color.WHITE;
            case DIED: return Color.BLUE;
        }
    }
}

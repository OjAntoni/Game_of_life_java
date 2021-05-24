package com.pw_team.model;

import java.awt.*;

/**
 * Klasa config jest stworzona do zdefiniowania warunków pola gry
 * SIZE - wyznacza rozmiar pojedyńczej komórki, którą my widzimy
 * WIDTH, HEIGHT - rozmiary pola gry. Rozmiar jest tworzony na podstawie wzoru
 * [Config.SIZE * Config.WIDTH + 25, Config.SIZE * Config.HEIGHT + 45],
 * czyli  faktyczne my zmieniamy ilość komorek poziomo i pionowo
 */
public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int SLEEPMS = 100;
    /**
     * Statyczna metoda dla dodawania koloru komórce zgodnie z jej statusem
     * @param status status wybranej komórki
     * @return zwraca kolor, który ma zostać przypisany komórce
     * W case NONE jest wyznaczany 'background color' dla naszego pola
     */
    public static Color getCollor(Status status) {
        return switch (status) {
            case NONE -> Color.WHITE;
            case BORN -> Color.YELLOW;
            case LIVE -> Color.ORANGE;
            case DIED -> Color.RED;
        };
    }
}

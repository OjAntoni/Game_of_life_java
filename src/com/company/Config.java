package com.company;

import java.awt.*;

/**
 * Klasa config jest stworzona do zdefiniowania warunków pola gry
 * SIZE - wyznacza rozmiar pojedyńczej komórki, którą my widzimy
 * WIDTH, HEIGHT - rozmiary pola gry. Rozmiar jest tworzony na podstawie wzoru
 * [Config.SIZE * Config.WIDTH + 25, Config.SIZE * Config.HEIGHT + 45],
 * czyli  faktyczne my zmieniamy ilość komorek poziomo i pionowo
 */
public class Config {
    public static final int SIZE = 5;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public static final int SLEEPMS = 200;

    /**
     * Statyczna metoda dla dodawania koloru komórce zgodnie z jej statusem
     * @param status status wybranej komórki
     * @return zwraca kolor, który ma zostać przypisany komórce
     * W case NONE jest wyznaczany 'background color' dla naszego pola
     */
    public static Color getCollor(Status status) {
        return switch (status) {
            case NONE -> Color.BLACK;
            case BORN -> Color.GRAY;
            case LIVE -> Color.WHITE;
            case DIED -> Color.BLUE;
        };
    }
}

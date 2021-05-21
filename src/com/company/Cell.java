package com.company;

import java.util.ArrayList;

/**
 * Klasa Cell służy do przechowywania bazowych informacji
 * o komórce: dynamicznie zachowującą się tablicę sąsiednich komórek
 *            Aktualny status komórki z enum Status
 */
public class Cell {
    public ArrayList<Cell> near;
    private Status status;

    public Cell() {
        setStatus(Status.NONE);
        near = new ArrayList<>();
    }
    void addNear(Cell cell){
        near.add(cell);
    }

    /**
     * step1() liczy sąsiadów i nadaje odpowidni status tej komórce
     * przy pomocy metody step1() zdefiniowanej w enum Status,
     * która zmienia NONE -> BORN i LIVE -> DIED przy odpowiednich warunkach
     */
    public void step1() {
        int around = countNearCells();
        setStatus(getStatus().step1(around));
    }

    /**
     * step() działa podobnie do step1() ale bez względu na sąsiadów komórki
     * zmienia przy pomocy metody step2() zdefiniowanej w enum Status
     * BORN -> LIVE i DIED -> NONE
     */
    public void step2() {
        setStatus(getStatus().step2());
    }

    public int countNearCells() {
        int count = 0;
        for (Cell cell : near)
            if (cell.getStatus().isCell())
                count++;
        return count;

    }

    /**
     * metoda turn() zmienia wszystkich żyjących sąsiadów na pustych \
     * i pustych na żyjących
     */
    void turn(){
        for (Cell cell : near)
            cell.setStatus(cell.getStatus().isCell() ? Status.NONE : Status.LIVE);
    }

    public com.company.Status getStatus() {
        return status;
    }

    public void setStatus(com.company.Status status) {
        this.status = status;
    }
}

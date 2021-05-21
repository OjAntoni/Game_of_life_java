package com.company;

import java.util.ArrayList;

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
    void step1() {
        int around = countNearCells();
        setStatus(getStatus().step1(around));
    }

    void step2() {
        setStatus(getStatus().step2());
    }

    int countNearCells() {
        int count = 0;
        for (Cell cell : near)
            if (cell.getStatus().isCell())
                count++;
        return count;

    }
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

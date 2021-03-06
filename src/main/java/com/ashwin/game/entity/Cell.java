package com.ashwin.game.entity;

import com.ashwin.game.entity.command.CommandMap;

import java.util.List;

public class Cell {
    private final Coordinate coordinate;
    private Atom atom;
    private final List<Cell> surrounding;

    public Cell(Coordinate coordinate, Atom atom, List<Cell> surrounding) {
        this.coordinate = coordinate;
        this.atom = atom;
        this.surrounding = surrounding;
    }

    public void spawnAtom() {
        this.atom = new Atom();
    }

    public void killAtom() {
        if (atom != null)
            this.atom.die();
    }

    public boolean hasLiveAtom() {
        return this.atom != null && this.atom.isAlive();
    }

    public void act() {
        CommandMap.command.get(liveSurroundings()).execute(this);
    }

    private Integer liveSurroundings() {
        int liveCount = 0;
        for (Cell cell : surrounding) {
            if (cell.hasLiveAtom())
                liveCount++;
        }
        return liveCount;
    }

    public void gotoNextGen(){
        this.atom.updateSelfToThisGen();
    }
}

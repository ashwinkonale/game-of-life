package com.ashwin.game.entity;

public class Cell {
    private Position position;
    private Atom atom;

    public Cell(int x, int y, Atom atom) {
        this.position = new Position(x, y);
        this.atom = atom;
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
}

package com.ashwin.game.entity.state;

public class DeadState implements AtomState {
    @Override
    public AtomState die() {
        System.out.println("Already dead");
        return this;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public AtomState live() {
        System.out.println("Cannot resurrect atom");
        return this;
    }
}

package com.ashwin.game.entity.state;

public class LiveState implements AtomState {

    @Override
    public AtomState die() {
        return new DeadState();
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public AtomState live() {
        return this;
    }
}

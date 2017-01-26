package com.ashwin.game.entity;

import com.ashwin.game.entity.state.AtomState;
import com.ashwin.game.entity.state.LiveState;

public class Atom {
    AtomState currentState;
    AtomState changedState;

    public Atom() {
        this.currentState = new LiveState();
        this.changedState = new LiveState();
    }

    public boolean isAlive() {
        return currentState.isAlive();
    }

    public void die() {
        this.changedState = this.currentState.die();
    }

    public void live() {
        this.changedState = this.currentState.live();
    }

    public void updateSelfToThisGen() {
        this.currentState = changedState;
    }
}

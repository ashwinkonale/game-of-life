package com.ashwin.game.entity.state;

public interface AtomState {
    AtomState die();
    AtomState live();
    boolean isAlive();

}

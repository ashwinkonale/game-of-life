package com.ashwin.game.entity;


import com.ashwin.game.entity.state.DeadState;
import com.ashwin.game.entity.state.LiveState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtomTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNewAtomShouldBeALive() throws Exception {
        Atom atom = new Atom();
        assertTrue(atom.isAlive());
        assertEquals(atom.currentState.getClass(), LiveState.class);
        assertEquals(atom.changedState.getClass(), LiveState.class);
    }

    @Test
    public void shouldChangeStateToDeadWhenDied() throws Exception {
        Atom atom = new Atom();
        assertTrue(atom.isAlive());
        atom.die();
        assertEquals(atom.currentState.getClass(), LiveState.class);
        assertEquals(atom.changedState.getClass(), DeadState.class);
    }

    @Test
    public void shouldNotBeAbleToChangeAtomWhichisAlreadyDead() throws Exception {
        Atom atom = new Atom();
        atom.die();
        atom.updateSelfToThisGen();
        assertEquals(DeadState.class, atom.currentState.getClass());
        assertFalse(atom.isAlive());
        atom.live();
        assertEquals(DeadState.class, atom.changedState.getClass());
    }

    @Test
    public void shouldBeAbleToLiveAtomToNextGen() throws Exception {
        Atom atom = new Atom();
        atom.live();
        atom.updateSelfToThisGen();
        assertEquals(LiveState.class, atom.currentState.getClass());
        assertEquals(LiveState.class, atom.changedState.getClass());
    }
}
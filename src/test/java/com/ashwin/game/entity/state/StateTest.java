package com.ashwin.game.entity.state;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
    private LiveState livestate;
    private DeadState deadstate;

    @Before
    public void setup() throws Exception {
        livestate = new LiveState();
        deadstate = new DeadState();
    }

    @Test
    public void testShouldChangeStateToDeadFromAlive() throws Exception {
        AtomState changedState = livestate.die();
        assertThat(changedState, CoreMatchers.instanceOf(DeadState.class));
    }

    @Test
    public void testIsAlive() throws Exception {
        assertTrue(livestate.isAlive());
    }

    @Test
    public void testLive() throws Exception {
        AtomState changedState = livestate.live();
        assertThat(changedState, CoreMatchers.instanceOf(LiveState.class));
    }

    @Test
    public void testShouldNotChangeStateToAliveFromDead() throws Exception {
        AtomState changedState = deadstate.die();
        assertThat(changedState, CoreMatchers.instanceOf(DeadState.class));
    }

    @Test
    public void testIsDead() throws Exception {
        assertFalse(deadstate.isAlive());
    }

    @Test
    public void testDeadShouldNotComeToLive() throws Exception {
        AtomState changedState = deadstate.live();
        assertThat(changedState, CoreMatchers.instanceOf(DeadState.class));
    }

}
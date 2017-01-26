package com.ashwin.game.entity.state;

import junit.framework.TestCase;

public class StateTest extends TestCase {
    public void testShouldChangeStateToDeadFromAlive() throws Exception {
        LiveState livestate = new LiveState();
        livestate.die();

    }

    public void testIsAlive() throws Exception {

    }

    public void testLive() throws Exception {

    }

}
package com.ashwin.game.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CellTest {
    private Cell cellWithNoLiveCells;
    private Atom atom;

    @Before
    public void setUp() throws Exception {
        Position p00 = new Position(0, 0);
        Position p01 = new Position(0, 1);
        Position p02 = new Position(0, 2);
        Position p10 = new Position(1, 0);
        Position p11 = new Position(1, 1);
        Position p12 = new Position(1, 2);
        Position p20 = new Position(2, 3);
        Position p21 = new Position(2, 3);
        Position p22 = new Position(2, 3);
        List<Cell> surrounding = Arrays.asList(
                new Cell(p00, null, new ArrayList<Cell>()),
                new Cell(p01, null, new ArrayList<Cell>()),
                new Cell(p02, null, new ArrayList<Cell>()),
                new Cell(p10, null, new ArrayList<Cell>()),
                new Cell(p12, null, new ArrayList<Cell>()),
                new Cell(p20, null, new ArrayList<Cell>()),
                new Cell(p21, null, new ArrayList<Cell>()),
                new Cell(p22, null, new ArrayList<Cell>())
        );
        atom = mock(Atom.class);
        cellWithNoLiveCells = new Cell(p11, atom, surrounding);
    }

    @Test
    public void testSpawnAtom() throws Exception {
    }

    @Test
    public void testKillAtom() throws Exception {
        cellWithNoLiveCells.killAtom();
        verify(atom).die();
    }

    @Test
    public void testHasLiveAtom() throws Exception {
        when(atom.isAlive()).thenReturn(true);
        assertTrue(cellWithNoLiveCells.hasLiveAtom());
    }

    public void testAct() throws Exception {

    }

}
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
        Coordinate p00 = new Coordinate(0, 0);
        Coordinate p01 = new Coordinate(0, 1);
        Coordinate p02 = new Coordinate(0, 2);
        Coordinate p10 = new Coordinate(1, 0);
        Coordinate p11 = new Coordinate(1, 1);
        Coordinate p12 = new Coordinate(1, 2);
        Coordinate p20 = new Coordinate(2, 3);
        Coordinate p21 = new Coordinate(2, 3);
        Coordinate p22 = new Coordinate(2, 3);
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
        cellWithNoLiveCells.spawnAtom();
        assertTrue(cellWithNoLiveCells.hasLiveAtom());
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

    @Test
    public void testShouldBeAbleToUpdateAtom() throws Exception {
        cellWithNoLiveCells.gotoNextGen();
        verify(atom).updateSelfToThisGen();
    }

}
package com.ashwin.game.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CellIntegrationTest {
    private Cell cellWithNoAdjacentLiveCells;
    private Cell cellWithTwoAdjacentLiveCells;
    private Cell cellWithThreeAdjacentLiveCells;
    private Cell cellWithFiveAdjacentLiveCells;
    private Cell deadCellWithThreeLiveNeighbours;

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

        List<Cell> surroundingWithTwoLiveCells = Arrays.asList(
                new Cell(p00, null, new ArrayList<Cell>()),
                new Cell(p01, null, new ArrayList<Cell>()),
                new Cell(p02, null, new ArrayList<Cell>()),
                new Cell(p10, null, new ArrayList<Cell>()),
                new Cell(p12, null, new ArrayList<Cell>()),
                new Cell(p20, null, new ArrayList<Cell>()),
                new Cell(p21, new Atom(), new ArrayList<Cell>()),
                new Cell(p22, new Atom(), new ArrayList<Cell>())
        );

        List<Cell> surroundingWithThreeLiveCells = Arrays.asList(
                new Cell(p00, null, new ArrayList<Cell>()),
                new Cell(p01, null, new ArrayList<Cell>()),
                new Cell(p02, null, new ArrayList<Cell>()),
                new Cell(p10, null, new ArrayList<Cell>()),
                new Cell(p12, null, new ArrayList<Cell>()),
                new Cell(p20, new Atom(), new ArrayList<Cell>()),
                new Cell(p21, new Atom(), new ArrayList<Cell>()),
                new Cell(p22, new Atom(), new ArrayList<Cell>())
        );

        List<Cell> surroundingWithFiveLiveCells = Arrays.asList(
                new Cell(p00, null, new ArrayList<Cell>()),
                new Cell(p01, null, new ArrayList<Cell>()),
                new Cell(p02, null, new ArrayList<Cell>()),
                new Cell(p10, new Atom(), new ArrayList<Cell>()),
                new Cell(p12, new Atom(), new ArrayList<Cell>()),
                new Cell(p20, new Atom(), new ArrayList<Cell>()),
                new Cell(p21, new Atom(), new ArrayList<Cell>()),
                new Cell(p22, new Atom(), new ArrayList<Cell>())
        );

        cellWithNoAdjacentLiveCells = new Cell(p11, new Atom(), surrounding);
        cellWithTwoAdjacentLiveCells = new Cell(p11, new Atom(), surroundingWithTwoLiveCells);
        cellWithThreeAdjacentLiveCells = new Cell(p11, new Atom(), surroundingWithThreeLiveCells);
        cellWithFiveAdjacentLiveCells = new Cell(p11, new Atom(), surroundingWithFiveLiveCells);

        deadCellWithThreeLiveNeighbours = new Cell(p11, null, surroundingWithThreeLiveCells);

    }

    @Test
    public void shouldDieOfUnderpopulation(){
        cellWithNoAdjacentLiveCells.act();
        cellWithNoAdjacentLiveCells.gotoNextGen();
        assertFalse(cellWithNoAdjacentLiveCells.hasLiveAtom());
        // cell with 2 neighbours doesnt die of underpopulation
        cellWithTwoAdjacentLiveCells.act();
        cellWithTwoAdjacentLiveCells.gotoNextGen();
        assertTrue(cellWithTwoAdjacentLiveCells.hasLiveAtom());
    }

    @Test
    public void shouldLiveToNextGen(){
        cellWithTwoAdjacentLiveCells.act();
        cellWithTwoAdjacentLiveCells.gotoNextGen();
        assertTrue(cellWithTwoAdjacentLiveCells.hasLiveAtom());
        cellWithThreeAdjacentLiveCells.act();
        cellWithThreeAdjacentLiveCells.gotoNextGen();
        assertTrue(cellWithThreeAdjacentLiveCells.hasLiveAtom());
    }

    @Test
    public void shouldDieOfOverPopulation(){
        cellWithFiveAdjacentLiveCells.act();
        cellWithFiveAdjacentLiveCells.gotoNextGen();
        assertFalse(cellWithFiveAdjacentLiveCells.hasLiveAtom());
    }

    @Test
    public void shouldSpawnNewAtomIfThereAreExactlyThreeNeighbors(){
        assertFalse(deadCellWithThreeLiveNeighbours.hasLiveAtom());
        deadCellWithThreeLiveNeighbours.act();
        deadCellWithThreeLiveNeighbours.gotoNextGen();
        assertTrue(cellWithThreeAdjacentLiveCells.hasLiveAtom());
    }
}

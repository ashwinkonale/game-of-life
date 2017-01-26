package com.ashwin.game.entity.command;

import com.ashwin.game.entity.Cell;

public class Resurrect implements CellCommand {
    @Override
    public void execute(Cell cell) {
        cell.spawnAtom();
    }
}

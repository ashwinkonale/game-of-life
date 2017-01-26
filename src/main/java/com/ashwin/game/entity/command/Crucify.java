package com.ashwin.game.entity.command;

import com.ashwin.game.entity.Cell;

public class Crucify implements CellCommand {
    @Override
    public void execute(Cell cell) {
        cell.killAtom();
    }
}

package com.ashwin.game.entity.command;

import com.ashwin.game.entity.Cell;

public class Exempt implements CellCommand {
    @Override
    public void execute(Cell cell) {
        // no op
    }
}

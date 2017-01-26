package com.ashwin.game.entity.command;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    public static Map<Integer, CellCommand> command = new HashMap<>();
    static {
        Crucify crucify = new Crucify();
        Resurrect resurrect = new Resurrect();
        Exempt exempt = new Exempt();
        command.put(0, crucify);
        command.put(1, crucify);
        command.put(2, exempt);
        command.put(3, resurrect);
        command.put(4, crucify);
        command.put(5, crucify);
        command.put(6, crucify);
        command.put(7, crucify);
    }
}

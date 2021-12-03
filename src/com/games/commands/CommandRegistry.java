package com.games.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {

    List<ICommand> commands = new ArrayList<>();

    public void addCommand(ICommand iCommand) {
        commands.add(iCommand);
    }

    public void executeCommand(String command) {
        for(ICommand c: commands) {
            if(c.matches(command)) {
                c.execute(command);
                return;
            }
        }
    }

}

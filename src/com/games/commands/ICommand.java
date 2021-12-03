package com.games.commands;

public interface ICommand {
    public boolean matches(String command);
    public void execute(String command);
}

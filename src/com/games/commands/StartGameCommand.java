package com.games.commands;

import com.games.controller.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartGameCommand implements ICommand {

    GameController controller = new GameController();

    @Override
    public boolean matches(String command) {
        String[] words = command.split(" ");
        if(words[0].equalsIgnoreCase("START")) return true;
        return false;
    }

    @Override
    public void execute(String command) {
        System.out.println("inside execute");

        String[] words = command.split(" ");
        int boardSize = Integer.parseInt(words[1]);
        String player1Name = words[2];
        String player2Name = words[3];

        controller.startGame(boardSize, player1Name, player2Name);

    }
}

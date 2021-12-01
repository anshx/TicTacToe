package com.games.client;

import com.games.exception.GameException;
import com.games.factory.PlayerFactory;
import com.games.model.Game;
import com.games.model.Player;
import com.games.strategy.SimplePlayingStrategy;
import com.games.strategy.SimpleWinningStrategy;

import java.util.Scanner;

public class Client {
    static Scanner ss = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            buildGame();
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void buildGame() throws GameException {

        Game game = Game.getBuilder().addPlayer(PlayerFactory.createHumanPlayer()
                        .addSymbol('X')
                        .addPlayName("AnshX")
                        .build())
                .addPlayer(PlayerFactory.createBotPlayer()
                        .addSymbol('O')
                        .addStrategy(new SimplePlayingStrategy())
                        .addPlayName("Computer")
                        .build())
                .addBoard(3)
                .addWinningStrategy(new SimpleWinningStrategy())
                .build();

        game.run();

    }



}

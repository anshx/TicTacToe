package com.games.controller;

import com.games.exception.GameException;
import com.games.model.Game;
import com.games.service.GameService;

public class GameController {

    GameService service = new GameService();

    public void startGame(int n, String player1, String player2) {
        try {
            Game game = service.buildGame(n , player1, player2);
            service.run(game);
        } catch (GameException e) {
            e.printStackTrace();
        }
    }

}

package com.games.service;

import com.games.constants.GameStatus;
import com.games.exception.GameException;
import com.games.factory.PlayerFactory;
import com.games.model.Game;
import com.games.model.Move;
import com.games.strategy.IWinningStrategy;
import com.games.strategy.SimplePlayingStrategy;
import com.games.strategy.SimpleWinningStrategy;

public class GameService {

    public void run(Game game) {

        while (game.getGameStatus() == GameStatus.ONGOING) {
            System.out.println("Turn: " + game.getCurrentPlayer().getName());

            Move move = game.getCurrentPlayer().play(game);
            game.updateBoard(move);

            if(game.getAvailableMoves().size()==0) {
                game.setGameStatus(GameStatus.DRAW);
            }
            game.getBoard().displayBoard();
            for(IWinningStrategy strategy: game.getWinningStrategy()) {
                game.setWinner(strategy.checkWinner(game));
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------");

            game.switchPlayer();
        }

        game.printResult();
    }

    public Game buildGame(int n, String player1, String player2) throws GameException {
        Game game = Game.getBuilder()
                .addPlayer(PlayerFactory.createHumanPlayer()
                        .addSymbol('X')
                        .addPlayName(player1)
                        .build())
                .addPlayer(PlayerFactory.createBotPlayer()
                        .addSymbol('O')
                        .addStrategy(new SimplePlayingStrategy())
                        .addPlayName(player2)
                        .build())
                .addBoard(n)
                .addWinningStrategy(new SimpleWinningStrategy())
                .build();
        return game;
    }


}

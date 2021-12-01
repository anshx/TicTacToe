package com.games.strategy;

import com.games.model.Game;
import com.games.model.Player;

public interface IWinningStrategy {
    public Player checkWinner(Game game);
}

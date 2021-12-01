package com.games.strategy;

import com.games.model.Board;
import com.games.model.Game;
import com.games.model.Move;

public interface IPlayingStrategy {
    Move play(Game game);
}

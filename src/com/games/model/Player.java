package com.games.model;

import com.games.constants.PlayerType;

public abstract class Player {
    Symbol symbol;
    PlayerType type;
    String name;

    abstract Move play(Game game);

}

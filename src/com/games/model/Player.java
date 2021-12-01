package com.games.model;

import com.games.constants.PlayerType;

public abstract class Player {
    private Symbol symbol;
    private PlayerType type;
    private String name;

    abstract Move play(Game game);

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

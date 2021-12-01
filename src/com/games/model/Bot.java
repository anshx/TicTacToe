package com.games.model;

import com.games.constants.PlayerType;
import com.games.strategy.IPlayingStrategy;

public class Bot extends Player {

    IPlayingStrategy strategy;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    Move play(Game game) {
        return this.strategy.play(game);
    }

    public static class Builder {
        Bot bot;
        Builder() {
            this.bot = new Bot();
        }

        public Builder addSymbol(char ch) {
            this.bot.symbol = new Symbol(ch);
            return this;
        }

        public Builder addStrategy(IPlayingStrategy strategy) {
            this.bot.strategy = strategy;
            return this;
        }

        public Builder addPlayName(String name) {
            this.bot.name = name;
            return this;
        }

        public Bot build() {
            this.bot.type = PlayerType.BOT;
            return this.bot;
        }

    }

}

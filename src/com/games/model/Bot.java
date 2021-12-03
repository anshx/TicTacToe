package com.games.model;

import com.games.constants.PlayerType;
import com.games.strategy.IPlayingStrategy;

public class Bot extends Player {

    IPlayingStrategy strategy;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Move play(Game game) {
        return this.strategy.play(game);
    }

    public static class Builder {
        Bot bot;
        Builder() {
            this.bot = new Bot();
        }

        public Builder addSymbol(char ch) {
            this.bot.setSymbol(new Symbol(ch));
            return this;
        }

        public Builder addStrategy(IPlayingStrategy strategy) {
            this.bot.strategy = strategy;
            return this;
        }

        public Builder addPlayName(String name) {
            this.bot.setName(name);
            return this;
        }

        public Bot build() {
            this.bot.setType(PlayerType.BOT);
            return this.bot;
        }

    }

}

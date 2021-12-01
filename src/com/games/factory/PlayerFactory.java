package com.games.factory;

import com.games.model.Bot;
import com.games.model.Game;
import com.games.model.HumanPlayer;

public class PlayerFactory {

    public static HumanPlayer.Builder createHumanPlayer() {
        return HumanPlayer.getBuilder();
    }

    public static Bot.Builder createBotPlayer() {
        return Bot.getBuilder();
    }

}

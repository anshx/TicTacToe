package com.games.strategy;

import com.games.model.Board;
import com.games.model.Game;
import com.games.model.Move;

import java.util.Random;

public class SimplePlayingStrategy implements IPlayingStrategy {

    @Override
    public Move play(Game game) {
        Random random = new Random();
        Move move = null;
        int i = 0;
        for(Move avaMoves: game.getAvailableMoves()) {
           if(random.nextInt(++i) == 0) {
               move = avaMoves;
           }
        }
        return move;
    }
}

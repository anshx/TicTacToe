package com.games.strategy;

import com.games.model.*;

import java.util.List;

public class SimpleWinningStrategy implements IWinningStrategy {

    @Override
    public Player checkWinner(Game game) {

        List<List<Cell>> board= game.getBoard().getBoard();
        int size = board.size();
        //System.out.println(size);
        boolean hasWon = false;

        //check row wise
        for(int i=1;i<size;i++) {
            Symbol symbol = board.get(i).get(1).getSymbol();
            int count = 0;
            if(symbol == null) continue;
            for(int j=1;j<size;j++) {
                if(board.get(i).get(j).getSymbol() != null && board.get(i).get(j).getSymbol().getCh() == symbol.getCh()) {
                    count++;
                }else {
                    break;
                }
            }
            if(count == size-1) {
                hasWon = true;
                break;
            }
        }


        //check column wise
        for(int j=1;j<size;j++) {
            Symbol symbol = board.get(1).get(j).getSymbol();
            int count = 0;
            if(symbol == null) continue;
            for(int i=1;i<size;i++) {
                if(board.get(i).get(j).getSymbol() != null && board.get(i).get(j).getSymbol().getCh() == symbol.getCh()) {
                    count++;
                }else {
                    break;
                }
            }
            if(count == size-1) {
                hasWon = true;
                break;
            }
        }

        return (hasWon) ? game.getCurrentPlayer() : null;

    }

}

package com.games.strategy;

import com.games.constants.GameStatus;
import com.games.model.*;

import java.util.List;

public class SimpleWinningStrategy implements IWinningStrategy {

    @Override
    public Player checkWinner(Game game) {

        List<List<Cell>> board= game.getBoard().getBoard();
        int size = board.size();
        //System.out.println(size);
        boolean hasWon = false;

        if( checkRow(board, size) ||
            checkColumn(board, size) ||
            checkRightDiagonal(board, size) || checkLeftDiagonal(board, size)) {
            game.setGameStatus(GameStatus.RESULT);
            return game.getCurrentPlayer();
        }

        return null;

    }

    private boolean checkRow(List<List<Cell>> board, int size) {
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
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(List<List<Cell>> board, int size) {
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
                return true;
            }
        }
        return false;
    }

    private boolean checkRightDiagonal(List<List<Cell>> board, int size) {
        Symbol symbol = board.get(1).get(1).getSymbol();
        if(symbol == null) return false;
        for(int i=1;i<size;i++) {
            if(board.get(i).get(i).getSymbol() == null || board.get(i).get(i).getSymbol().getCh() != symbol.getCh()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonal(List<List<Cell>> board, int size) {
        Symbol symbol = board.get(1).get(size-1).getSymbol();
        if(symbol == null) return false;
        for(int i=1,j=size-1;j>0;i++,j--) {
            if(board.get(i).get(j).getSymbol() == null || board.get(i).get(j).getSymbol().getCh() != symbol.getCh()) {
                return false;
            }
        }
        return true;
    }


}

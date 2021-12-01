package com.games.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> board;
    private int n;

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public Board(int n) {
        this.n = n;
        this.board = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            this.board.add(new ArrayList<>());
            for(int j=0;j<=n;j++) {
                this.board.get(i).add(new Cell(i, j, null));
            }
        }
    }

    public void displayBoard() {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                System.out.print(this.board.get(i).get(j).getSymbol() == null ?
                            " - " : this.board.get(i).get(j).getSymbol().getCh() + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return n;
    }
}

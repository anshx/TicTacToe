package com.games.model;

import com.games.exception.GameException;
import com.games.strategy.IWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Set<Move> availableMoves;
    private List<IWinningStrategy> winningStrategy;
    private Player currentPlayer;

    private Game() {
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.availableMoves = new HashSet<>();
        this.winningStrategy = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Set<Move> getAvailableMoves() {
        return availableMoves;
    }

    public void setAvailableMoves(Set<Move> availableMoves) {
        this.availableMoves = availableMoves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void run() {
        while (true) {
            System.out.println("Turn: " + this.currentPlayer.name);
            Move move = currentPlayer.play(this);
            updateBoard(move);
            if(this.getAvailableMoves().size()==0) {
                System.out.println("Match Drawn....");
                break;
            }
            board.displayBoard();
            for(IWinningStrategy strategy: this.winningStrategy) {
                Player winner = strategy.checkWinner(this);
                if( winner != null) {
                    System.out.println("Player " + winner.name + "(" + winner.symbol.getCh() + ") has won");
                    return;
                }
            }

            System.out.println();
            System.out.println("---------------------------------------------------------------------------");

            this.currentPlayer = switchPlayer();
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Player switchPlayer() {
        int i = 0;
        for(Player player: this.getPlayers()) {
            //System.out.println(player);
            if(player.symbol.getCh() == this.currentPlayer.symbol.getCh()) {
                break;
            }
            i++;
        }
        i++;
        return this.getPlayers().get(i%this.getPlayers().size());
    }

    public void updateBoard(Move move) {
        this.getMoves().add(move);
        this.getAvailableMoves().remove(move);
        this.getBoard().getBoard().get(move.getX()).get(move.getY()).setSymbol(this.getCurrentPlayer().symbol);
    }

    public static class Builder {
        Game game;

        Builder() {
            this.game = new Game();
        }

        public Builder addPlayer(Player player) {
            if(this.game.currentPlayer == null) {
                this.game.currentPlayer = player;
            }
            this.game.players.add(player);
            return this;
        }

        public Builder addBoard(int n) {
            this.game.board = new Board(n);
            return this;
        }

        public Builder addWinningStrategy(IWinningStrategy strategy) {
            this.game.winningStrategy.add(strategy);
            return this;
        }

        public Game build() throws GameException{
            if(this.game.players.size() < 2) {
                throw new GameException("Players should be more than 2... Exiting");
            }
            for(int i=1;i<=this.game.board.getSize();i++) {
                for(int j=1;j<=this.game.board.getSize();j++) {
                    this.game.getAvailableMoves().add(new Move(i,j));
                }
            }
            return this.game;
        }

    }

}
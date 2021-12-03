package com.games.model;

import com.games.constants.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private User user;
    private static Scanner scanner = new Scanner(System.in);

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Move play(Game game) {
        Move move = null;
        int size = game.getBoard().getBoard().size()-1;
        while(true) {
            System.out.println("Enter the X co-ordinate... ( Enter a number between 1 to " + size + " )");
            int x = scanner.nextInt();
            System.out.println("Enter the Y co-ordinate... ( Enter a number between 1 to " + size + " )");
            int y = scanner.nextInt();
            if(x >= 1 && x<=size && y>=1 && y<=size) {
                move = new Move(x,y);
                break;
            }else {
                System.out.println("Please enter again :)");
            }
        }
        return move;
    }

    public static class Builder {
        HumanPlayer humanPlayer;

        private Builder() {
            this.humanPlayer = new HumanPlayer();
            this.humanPlayer.user = new User();
        }

//        public Builder addUserName(String name) {
//            this.humanPlayer.user.setName(name);
//            return this;
//        }
//
//        public Builder addUserAge(String age) {
//            this.humanPlayer.user.setAge(age);
//            return this;
//        }
//
//        public Builder addUserCountry(String country) {
//            this.humanPlayer.user.setCountry(country);
//            return this;
//        }

        public Builder addSymbol(char ch) {
            this.humanPlayer.setSymbol(new Symbol(ch));
            return this;
        }

        public Builder addPlayName(String name) {
            this.humanPlayer.setName(name);
            return this;
        }

        public HumanPlayer build() {
            this.humanPlayer.setType(PlayerType.HUMAN);
            return this.humanPlayer;
        }

    }

}

package br.edu.ifsp.remake;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private Card vira;

    private Player player1;
    private Player player2;

    private Round[] rounds = new Round[3];
    private int countRound = 0;

    private Deck deck;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.deck = new Deck();
        this.deck.shuffle();
        this.vira = deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
    }

    public void playRound() {
        if (isDone()) {
            System.out.println("Hand is already done!");
            return;
        }
        Round round = new Round(player1, player1.chooseCard(), player2, player2.chooseCard(), vira);
        rounds[countRound] = round;
        countRound++;
        if (round.getWinner() == null) {
            System.out.println("Round " + countRound + ": Tie");
            return;
        }
        System.out.println("Round " + countRound + ": " + round.getWinner() + " wins");

    }

    public boolean isDone() {
        int[] wins = countWins();
        int winsP1 = wins[0];
        int winsP2 = wins[1];
        if (winsP2 == 2 || winsP1 == 2) {
            return true;
        }

        return countRound == 3;

    }

    private int[] countWins() {
        int winsP1 = 0;
        int winsP2 = 0;

        for (int i = 0; i < countRound; i++) {
            String winner = rounds[i].getWinner();

            if (winner == null) continue;

            if (winner.equals(player1.getName())) {
                winsP1++;
            } else if (winner.equals(player2.getName())) {
                winsP2++;
            }
        }
        return new int[]{winsP1, winsP2};
    }

    public String getWinner() {
        if (!isDone()) {
            return null;
        }
        int[] wins = countWins();
        int winsP1 = wins[0];
        int winsP2 = wins[1];


        if (winsP1 > winsP2) return player1.getName();
        if (winsP2 > winsP1) return player2.getName();

        return null;
    }

}

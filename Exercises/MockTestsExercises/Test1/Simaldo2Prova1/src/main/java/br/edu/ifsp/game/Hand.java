package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

import java.util.Objects;

public class Hand {
    private Card vira;
    private Player player1;
    private Player player2;

    private Round[] rounds = new Round[3];
    int countRounds = 0;


    private Deck deck;


    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.deck = new Deck();
        this.deck.shuffle();

        this.vira = deck.takeOne();
        this.player1.setCards(deck.take(3));
        this.player2.setCards(deck.take(3));

    }

    public void playRound() {
        if (isDone()) {
            System.out.println("A mão já terminou!");
            return;
        }
        Round round = new Round(player1.getName(), player1.chooseCard(), player2.getName(), player2.chooseCard(), vira);
        rounds[countRounds++] = round;
        if (round.getWinner() == null) {
            System.out.println("Empate");
            return;
        }
        System.out.println("O player: " + round.getWinner() + " ganhou a rodada!");

    }

    private int[] countWins() {
        int winsP1 = 0;
        int winsP2 = 0;

        for (int i = 0; i < countRounds; i++) {
            String winner = rounds[i].getWinner();
            if (winner == null) continue;

            if (winner.equals(player1.getName())) winsP1++;
            else if (winner.equals(player2.getName())) winsP2++;
        }

        return new int[]{winsP1, winsP2};
    }

    public boolean isDone() {
        int[] wins = countWins();

        if (wins[0] == 2 || wins[1] == 2)
            return true;

        return countRounds == 3;
    }

    public String getWinner() {
        if (!isDone()) {
            return null;
        }

        String r1 = (countRounds > 0) ? rounds[0].getWinner() : null;
        String r2 = (countRounds > 1) ? rounds[1].getWinner() : null;
        String r3 = (countRounds > 2) ? rounds[2].getWinner() : null;

        if (r1 != null && r1.equals(r2))
            return r1;

        if (r1 == null && r2 != null)
            return r2;

        if (r2 == null && r1 != null)
            return r1;

        if (r1 == null && r2 == null)
            return r3;

        if (r3 == null)
            return r1;

        return r3;

    }

}

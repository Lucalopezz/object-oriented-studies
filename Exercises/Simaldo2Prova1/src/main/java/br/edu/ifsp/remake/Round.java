package br.edu.ifsp.remake;

import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;

    public Round(Player p1, Card card1, Player p2, Card card2, Card vira) {
        if (card1.compareValueTo(card2, vira) > 0) {
            this.winner = p1.getName();
        } else if (card1.compareValueTo(card2, vira) < 0) {
            this.winner = p2.getName();
        } else {
            this.winner = null;
        }


    }

    public String getWinner() {
        return winner;
    }
}

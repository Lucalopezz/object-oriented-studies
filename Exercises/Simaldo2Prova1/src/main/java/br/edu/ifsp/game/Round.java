package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private final String winner;

    
    public Round(String player1, Card card1, String player2, Card card2, Card vira){
        if (card1.compareValueTo(card2, vira) > 0){
            this.winner = player1;
        } else if (card1.compareValueTo(card2, vira) < 0) {
            this.winner = player2;
        }else{
            this.winner = null;
        }
    }
    
    public String getWinner(){
            return winner;
    }
}

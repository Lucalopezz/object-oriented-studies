package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private String name;
    private int score;
    private Card[] cards;


    public Player(String name) {
        this.name = name;
        this.cards = new Card[3];
        this.score = 0;
    }


    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    public Card chooseCard(){
         for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                Card chosen = cards[i];
                cards[i] = null;
                return chosen;
            }
        }
        return null;

    }

    public void incrementScore(){
        this.score++;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}

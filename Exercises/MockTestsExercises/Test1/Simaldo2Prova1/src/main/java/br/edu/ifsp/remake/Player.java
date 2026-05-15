package br.edu.ifsp.remake;

import br.edu.ifsp.deck.Card;

public class Player {
    private String name;
    private int score;
    private Card[] cards = new Card[3];

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Card chooseCard(){
        // Here cards.lenght always gonna be 3, because setCards always gone set 3 cards
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                Card chosenCard = cards[i];
                cards[i] = null;
                return chosenCard;
            }
        }
        return null;
    }

    public void incrementScore(){
        score++;
    }

    public String getName() {
        return name;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int getScore() {
        return score;
    }
}

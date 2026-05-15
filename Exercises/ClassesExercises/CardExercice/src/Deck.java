public class Deck {
    private Card[] cards;
    private int top;

    public Deck() {
        cards = new Card[52];

        int i = 0;
        for (Suits suit : Suits.values()){
            for (Ranks rank : Ranks.values()){
                cards[i++] = new Card(suit, rank);
            }
        }
        top = cards.length;
    }

    public Card drawOne() {
        if (top == 0)
            return null;

        return cards[--top];

    }

    public Card[] peekMore(int qty){
        if(top == 0) return null;

        if (qty > top) {
            qty = top;
        }

        Card[] peekedCards = new Card[qty];
        for (int i = 0; i < qty; i++) {
            peekedCards[i] = cards[top--];
        }
        return peekedCards;
    }

    public int restOfCards(){
        return top;
    }

}

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println("Cards remaining: " + deck.restOfCards());

        Card c1 = deck.drawOne();
        c1.turnFace();
        System.out.println("One card: " + c1);

        System.out.println("Cards remaining: " + deck.restOfCards());

        System.out.println("\nDrawing 5 cards:");

        Card[] hand = deck.peekMore(5);

        for (Card c : hand) {
            c.turnFace();
            System.out.println(c);
        }

        System.out.println("\nCards remaining: " + deck.restOfCards());
    }
}
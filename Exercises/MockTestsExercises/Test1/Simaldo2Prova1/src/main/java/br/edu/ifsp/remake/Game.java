package br.edu.ifsp.remake;

public class Game {
    private Player player1;
    private Player player2;

    private Hand[] hands = new Hand[30];
    private int countHands = 0;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        hands[countHands++] = new Hand(player1, player2);
    }

    public void play() {
        Hand currentHand = hands[countHands - 1];

        if (currentHand.isDone()) {

            String winner = currentHand.getWinner();

            if (winner != null) {
                if (winner.equals(player1.getName())) {
                    player1.incrementScore();
                    System.out.println(player1.getName() + " wins the hand!");
                } else if (winner.equals(player2.getName())) {
                    player2.incrementScore();
                    System.out.println(player2.getName() + " wins the hand!");
                }
            } else {
                System.out.println("Tie, nobody wins!");
            }

            hands[countHands++] = new Hand(player1, player2);
            currentHand = hands[countHands - 1];
        }

        currentHand.playRound();
    }

    public boolean isDone() {
        if (player1.getScore() == 12 || player2.getScore() == 12) {
            return true;
        }
        return false;
    }

    public Player getWinner() {
        if (!isDone()) {
            return null;
        }
        return player1.getScore() > player2.getScore() ? player1 : player2;
    }
}

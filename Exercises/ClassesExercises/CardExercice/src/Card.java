public class Card {
    private Suits suit;
    private Ranks rank;
    private boolean visible;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        this.visible = false; // Cards are hidden by default
    }
    public void turnFace(){
        visible = !visible;
    }

    @Override
    public String toString() {
        if(!visible){
            return "Hidden Card";
        }
        return rank + " of " + suit;
    }
}

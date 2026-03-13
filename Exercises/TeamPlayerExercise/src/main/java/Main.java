
public class Main {
    static void main() {
        Team team = new Team("Dream Team", "BR", "Jorge");
        Player player1 = new Player("Alice", 10, "Forward", true);
        Player player2 = new Player("Bob", 5, "Midfielder", true);
        Player player3 = new Player("Charlie", 1, "Goalkeeper", true);
        Player player4 = new Player("David", 7, "Defender", false);
        Player player5 = new Player("Eve", 3, "Defender", false);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);

        team.setCaptain(player1);
        System.out.println("\nCaptain: " + team.getCaptain().getStateAsString() + "\n");

        System.out.println("Fielded Players:");
        for (Player p : team.getFieldedPlayers()) {
            if (p != null) {
                System.out.println(p.getStateAsString());
            }
        }

        System.out.println("\nOutfielder Players:");
        for (Player p : team.getOutfieldedPlayers()) {
            if (p != null) {
                System.out.println(p.getStateAsString());
            }
        }
    }
}

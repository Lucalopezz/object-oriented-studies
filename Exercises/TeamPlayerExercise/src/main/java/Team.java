public class Team {
    private String name;
    private String baseLocation;
    private String coachName;

    private Player[] players = new Player[18];
    private int playerCount = 0;
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        System.out.println("Adding player: " + player.getStateAsString() + " to team: " + name);
        if (playerCount < 18) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Cannot add more players to the team. Maximum limit reached.");
        }
    }

    public void removePlayer(Player p) {
        if (playerCount == 0) {
            System.out.println("No players to remove from the team.");
            return;
        }
        int index = findPlayerIndex(p);
        if (index != -1) {
            // Shift players to fill the gap
            for (int i = index; i < playerCount - 1; i++) {
                players[i] = players[i + 1];
            }
        }

    }

    private int findPlayerIndex(Player p) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i] == p) {
                return i;
            }
        }
        return -1; // Player not found
    }
}

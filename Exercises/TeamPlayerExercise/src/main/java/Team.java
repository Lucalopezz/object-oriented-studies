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
    public void setCaptain(Player captain) {
        this.captain = captain;
    }
    public Player getCaptain() {
        return captain;
    }
    public String getCoachName(){
        return coachName;
    }
    public String getTeamName(){
        return name;
    }

    public void addPlayer(Player player) {
        System.out.println("Adding player: " + player.getStateAsString() + " to team: " + name);
        if (playerCount < 18) {
            player.setTeam(this);
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
        playerCount--;

    }

    public void substitute(Player substitute, Player starter) {
        if (playerCount == 0) {
            System.out.println("No players to substitute from the team.");
            return;
        }
        int index = findPlayerIndex(starter);
        if (index != -1) {
            players[index] = substitute;
        }
    }

    public Player[] getFieldedPlayers() {
        Player[] fieldedPlayers = new Player[11];
        int count = 0;
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getFielded()) {
                if (count < 11) {
                    fieldedPlayers[count] = players[i];
                    count++;
                } else {
                    players[i].setFielded(false);
                }
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        Player[] outPlayers = new Player[7];
        int count = 0;
        for (int i = 0; i < playerCount; i++) {
            if (!players[i].getFielded()) {
                if (count < 7) {
                    outPlayers[count] = players[i];
                    count++;
                } else {
                    players[i].setFielded(true);
                }
            }
        }
        return outPlayers;
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

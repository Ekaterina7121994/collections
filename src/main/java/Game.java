import java.util.HashMap;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {

        if (players.get(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        } else if (players.get(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (players.get(playerName1) > players.get(playerName2)) {
            return 1;
        } else if (players.get(playerName1) < players.get(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}

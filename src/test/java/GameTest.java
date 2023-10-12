import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void whenFirstPlayerStronger() {
        Player player1 = new Player(1, "Ира", 300);
        Player player2 = new Player(2, "Оля", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Ира", "Оля");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerStronger() {
        Player player1 = new Player(1, "Ира", 120);
        Player player2 = new Player(2, "Оля", 200);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Ира", "Оля");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerEqual() {
        Player player1 = new Player(1, "Ира", 200);
        Player player2 = new Player(2, "Оля", 200);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Ира", "Оля");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotRegistered() {
        Player player1 = new Player(1, "Ира", 200);
        Player player2 = new Player(2, "Оля", 200);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Катя", "Оля"));
    }

    @Test
    public void whenSecondPlayerNotRegistered() {
        Player player1 = new Player(1, "Ира", 200);
        Player player2 = new Player(2, "Оля", 200);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ира", "Маша"));
    }
}


package src;
import src.NumberGuessGame.NumberGuessGame;
import src.WordSearchGame.WordSearchGame;

import java.util.HashMap;
import java.util.Map;
public class GameSelector{

    private static final Map<Integer, IGame> games = new HashMap<>();

    static {
        games.put(1, new NumberGuessGame());
        games.put(2, new WordSearchGame());

    }
    public static IGame selectGame(int choice) {
        IGame selectedGame = games.get(choice);
        return selectedGame.createGame();



    }
}
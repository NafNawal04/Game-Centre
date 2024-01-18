package src;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WordGuessGame implements IGame {

    private static final Map<String, List<String>> wordHints = new HashMap<>();


    private static void initializeWordHints() {
        try {

            Path path = Paths.get("src", "WordSearchData.txt");
            List<String> lines = Files.readAllLines(path);

            for (String line : lines)
            {
                String[] parts = line.split(",");
                if (parts.length > 1)
                {
                    wordHints.put(parts[0].toUpperCase(), Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    public IGame createGame() {
        return new WordGuessGame();
    }

    @Override
    public void play() {
        initializeWordHints();
        System.out.println("Welcome to the Word Search Game!");
        System.out.println("You will be given a word. That word will have 5 hints. Guess that word! Good Luck!");

        Scanner scanner = new Scanner(System.in);

        List<String> shuffledWords = new ArrayList<>(wordHints.keySet());
        Collections.shuffle(shuffledWords);

        for (String word : shuffledWords) {
            List<String> hints = wordHints.get(word);
            int hintIndex = 0;
            int attempts = 0;

            System.out.println("\nHere's your first hint: " + hints.get(hintIndex));

            while (true) {
                System.out.print("Enter your guess: ");
                String userGuess = scanner.nextLine().toUpperCase();


                attempts++;

                if (userGuess.equals(word)) {
                    System.out.println("Congratulations! You guessed the word '" + word + "' in " + attempts + " attempts.");
                    System.out.print("Do you want to play?(YES/NO) ");
                    String input = scanner.nextLine().toUpperCase();
                    if (input.equals("NO")) {
                        System.out.println("Game exited. Thank you for playing!");
                        System.exit(0);
                    }
                    break;
                } else {
                    hintIndex++;
                    if (hintIndex < hints.size()) {
                        System.out.println("Incorrect. Here's your next hint: " + hints.get(hintIndex));
                    } else {
                        System.out.println("Sorry, you're out of hints. The correct word was '" + word + "'.");
                        System.out.print("Do you want to play?(YES/NO) ");
                        String input = scanner.nextLine().toUpperCase();
                        if (input.equals("NO")) {
                            System.out.println("Game exited. Thank you for playing!");
                            System.exit(0);
                        }
                        break;
                    }
                }
            }
        }

        scanner.close();
    }
}

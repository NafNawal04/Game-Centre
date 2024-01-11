package src.WordSearchGame;

import src.IGame;

import java.util.*;

public class WordSearchGame implements IGame {

    private static final Map<String, List<String>> wordHints = new HashMap<>();


    private static void initializeWordHints() {
        wordHints.put("JAVA", Arrays.asList("Programming language", "Platform-independent", "Object-oriented"));
        wordHints.put("WORD", Arrays.asList("Text document", "Microsoft Office", "Document editing"));
        wordHints.put("SEARCH", Arrays.asList("Look for something", "Find information", "Explore"));
        wordHints.put("CONSOLE", Arrays.asList("Text-based interface", "Command-line", "No graphical user interface"));
        wordHints.put("ARRAY", Arrays.asList("Ordered collection", "Indexed elements", "Homogeneous elements"));
        wordHints.put("RANDOM", Arrays.asList("Unpredictable", "Without a pattern", "Chance-based"));
    }



    private static void displayGrid() {

        System.out.println("The words you will be searching for will have 8 hints.");


    }

    @Override
    public IGame createGame() {
        return new WordSearchGame();
    }

    @Override
    public void play() {
        initializeWordHints();
        System.out.println("Welcome to the Word Search Game!");
        displayGrid();

        Scanner scanner = new Scanner(System.in);

        List<String> shuffledWords = new ArrayList<>(wordHints.keySet());
        Collections.shuffle(shuffledWords);

        for (String word : shuffledWords) {
            List<String> hints = wordHints.get(word);
            int hintIndex = 0;
            int attempts = 0;

            System.out.println("\nYour word has " + hints.size() + " hints. Here's your first hint: " + hints.get(hintIndex));

            while (true) {
                System.out.print("Enter your guess [or type 'EXIT' to quit]: ");
                String userGuess = scanner.nextLine().toUpperCase();

                if (userGuess.equals("EXIT")) {
                    System.out.println("Game exited. Thank you for playing!");
                    System.exit(0);
                }

                attempts++;

                if (userGuess.equals(word)) {
                    System.out.println("Congratulations! You guessed the word '" + word + "' in " + attempts + " attempts.");
                    break;
                } else {
                    hintIndex++;
                    if (hintIndex < hints.size()) {
                        System.out.println("Incorrect. Here's your next hint: " + hints.get(hintIndex));
                    } else {
                        System.out.println("Sorry, you're out of hints. The correct word was '" + word + "'.");
                        break;
                    }
                }
            }
        }

        scanner.close();
    }
}

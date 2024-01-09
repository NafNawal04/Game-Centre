package src;

public class GameSelector{

    public static IGame selectGame(int choice) {
        if(choice == 1)
        {
            return new NumberGuessGame();
        }
        else if(choice == 2)
        {
            return new WordSearchGame();
        }
        else
        {
            System.out.println("Invalid choice. Exiting...");
            System.exit(0);
            return null;
        }


    }
}
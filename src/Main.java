package src;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game Centre,players!");
        System.out.println("Choose a game to play");
        System.out.println("1. Number Guess Game");
        System.out.println("2. Word Search Game");
        System.out.println("3. Snake & Ladder Game");
        System.out.println("Press the desired option[0 to quit]: ");
        int choice = scanner.nextInt();

        if(choice == 0)
        {
            System.exit(0);
        }
        IGame selectedGame = GameSelector.selectGame(choice);
        GameOperator gameOperator = new GameOperator(selectedGame);
        gameOperator.playGame();

        scanner.close();
    }
}

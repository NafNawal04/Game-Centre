package src;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame implements IGame{
    @Override
    public void play(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the secret number between " + lowerBound + " and " + upperBound + ".");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("It's low! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("It's high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the secret number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}
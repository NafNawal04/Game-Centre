package src;

public class Main {
    public static void main(String[] args) {

        GameOperator gameOperator = new GameOperator(new NumberGuessGame());
        gameOperator.playGame();
    }
}

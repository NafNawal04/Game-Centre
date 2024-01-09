package src;

public class GameOperator {

    private IGame game;
    public GameOperator(IGame game)
    {
        this.game = game;
    }

    public void setGame(IGame game) {
        this.game = game;
    }
    public void playGame()
    {
        if (game != null)
        {
            game.play();
        }
        else
        {
            System.out.println("No game has been selected.");
        }
    }
}

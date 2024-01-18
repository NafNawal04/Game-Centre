package src;


public class SnakeLadderGame implements IGame {


    @Override
    public IGame createGame()
    {
        return new SnakeLadderGame();
    }
    @Override
    public void play()
    {
        System.out.println("Welcome to Snake Ladder Game!");
        System.out.println("Here, the number of players have limits of [2 - 6]");


        PlayModule gameStarted = new PlayModule();
        gameStarted.operateGame();




    }

}

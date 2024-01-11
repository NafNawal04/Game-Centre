package src.SnakeLadderGame;


public class PlayModule{
    PlayerInfo play = new PlayerInfo();

    int[] thePlayers = play.players;

    String[] thePlayerNames = play.playerNames;
    int[][] snakesValueDrop = {
            { 29, 9 },
            { 47, 4 },
            { 53, 33 },
            { 38, 15 },
            { 62, 37 },
            { 86, 54 },
            { 92, 70 },
            { 97, 25 }
    };
    int[][] laddersValueRise = {
            { 2, 23 },
            { 8, 34 },
            { 20, 77 },
            { 32, 68 },
            { 41, 79 },
            { 74, 88 },
            { 85, 95 },
            { 82, 99 }
    };





    public void operateGame()
    {

        while(!play.hasAnyPlayerWon())
        {
            for (int i = 0; i < play.numberOfPlayers; i++)
            {
                playerMakesMove(i);
                BoardInfo.printTheBoard(play.players);


                try{
                    Thread.sleep(4000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(" ");
                }

                if (play.players[i] >= 100)
                {
                    System.out.println("Game Ended.");
                    break;
                }


            }

        }


    }


    public void playerMakesMove(int playerNumber)
    {


            System.out.println("Rolling the dice for "+ thePlayerNames[playerNumber] + " .......");

            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                System.out.println(" ");
            }



            int rolledNumber = (int) (Math.random() * 6 - 1) + 1;
            thePlayers[playerNumber] += rolledNumber;

            if (thePlayers[playerNumber] > 100)
            {
                System.out.println(thePlayerNames[playerNumber] + " got out of box and Won!!");
            }
            else
            {
                checkGameStatus(thePlayers[playerNumber], playerNumber);
            }



    }

    public int afterSnakeAte(int playerCurrentPosition)
    {
        return play.checkPlayerNewPosition(snakesValueDrop, playerCurrentPosition);
    }

    public int afterFindingLadder(int playerCurrentPosition)
    {
        return play.checkPlayerNewPosition(laddersValueRise, playerCurrentPosition);
    }

    public void checkGameStatus(int playerPosition, int playerNumber) {
        int playerPositionForSnake = afterSnakeAte(playerPosition);
        int playerPositionForLadder = afterFindingLadder(playerPosition);
        System.out.println("\n");
        if (playerPositionForSnake != -1)
        {

            System.out.println(thePlayerNames[playerNumber] + " got the position " + thePlayers[playerNumber] +" but got bit by snake! So now, is in the position of "
                    + playerPositionForSnake);
            thePlayers[playerNumber] = playerPositionForSnake;
        }
        else if (playerPositionForLadder!= -1)
        {

            System.out.println(thePlayerNames[playerNumber] +  " got the position " + thePlayers[playerNumber] +" and got the Ladder! So now, is in the position of "
                    + playerPositionForLadder);
            thePlayers[playerNumber] = playerPositionForLadder;
        }
        else
        {
            System.out.println(thePlayerNames[playerNumber] + " is in the position of " + thePlayers[playerNumber]);
        }
    }

}

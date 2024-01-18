package src;

import java.util.Scanner;

public class PlayerInfo {
    int[] players;

    int numberOfPlayers;
    String[] playerNames;

    public PlayerInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No of Players : ");
        numberOfPlayers = scanner.nextInt();
        players = new int[numberOfPlayers];
        playerNames = new String[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player " + (i + 1)+ " name:");
            playerNames[i] = scanner.next();
        }
        scanner.close();

    }



    public boolean hasAnyPlayerWon()
    {
        for (int playerNumber = 0; playerNumber < players.length; playerNumber++)
        {
            if (players[playerNumber] == 100)
            {
                System.out.println("Player " + (playerNumber + 1) + ": " + playerNames[playerNumber] + " has Won!! Congratulations! ");
                return true;
            }
        }
        return false;
    }


    //this method stops code duplication in other methods
    public int checkPlayerNewPosition(int[][] positions, int playerPosition)
    {
        for (int[] position : positions)
        {
            if (position[0] == playerPosition)
            {
                return position[1];
            }
        }
        return -1;
    }
}

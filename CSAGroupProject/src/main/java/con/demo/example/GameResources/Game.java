package con.demo.example.GameResources;

//@Author Auden
//@Author Dhruv

/** 
 * The following is the Game helper class.
 * It represents the entire game
 * It has an ArrayList of player that represent the current players
 * it has a 2d array of GameSquares that represent the board
 * it has a int field to keep track of whose turn it is 
 * 
 * It also has a constructor, a toString method, and getter's and setter's 
 * **/

import java.util.ArrayList;

public class Game 
{
    private ArrayList<Player> playerList;

    private GameSquare[][] board;

    private int currentPlayerTurn;


    public Game (ArrayList<Player> PlayerList, GameSquare[][] Board, int CurrentPlayerTurn)
    {
        playerList = PlayerList;
        board = Board;
        currentPlayerTurn = CurrentPlayerTurn;
        
    }

    public ArrayList<Player> getPlayerList(){return playerList;}
    public void setPlayerList(ArrayList<Player> PlayerList){playerList = PlayerList;}

    public GameSquare[][] getBoard(){return board;}
    public void setPlayerList(GameSquare[][] Board){board = Board;}

    public int getCurrentPlayerTurn(){return currentPlayerTurn;}
    public void setCurrentPlayerTurn(int CurrentPlayerTurn){currentPlayerTurn = CurrentPlayerTurn;}


    

    public String toString()
    {
        String returnString = "+";

        for (int i = 0; i < board[0].length; i++)
        {
            returnString += "-";
        }
        returnString += "+\n";

        for(int y = board.length - 1; y >= 0; y--)
        {
            returnString += "|";
            for (int x = 0; x < board.length;x++)
            {
                if (board[y][x].getUnit() == null)
                {
                    returnString += " ";
                }
                else
                {
                    returnString += board[y][x].getUnit().getType().substring(0,1);
                }
            }
            returnString += "|\n";
        }

        returnString += "+";

        for (int i = 0; i < board[0].length; i++)
        {
            returnString += "-";
        }
        returnString += "+";

        return returnString;
    }
}

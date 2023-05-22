package con.demo.example.GameResources;

import java.util.ArrayList;

public class Game 
{
    private ArrayList<Player> playerList;

    private GameSquare[][] board;

    private int currentPlayerTurn;

    private ArrayList<MoveRequest> currentMoves;

    public Game (ArrayList<Player> PlayerList, GameSquare[][] Board, int CurrentPlayerTurn)
    {
        playerList = PlayerList;
        board = Board;
        currentPlayerTurn = CurrentPlayerTurn;
        currentMoves = new ArrayList<>();
    }

    public ArrayList<Player> getPlayerList(){return playerList;}
    public void setPlayerList(ArrayList<Player> PlayerList){playerList = PlayerList;}

    public GameSquare[][] getBoard(){return board;}
    public void setPlayerList(GameSquare[][] Board){board = Board;}

    public int getCurrentPlayerTurn(){return currentPlayerTurn;}
    public void setCurrentPlayerTurn(int CurrentPlayerTurn){currentPlayerTurn = CurrentPlayerTurn;}


    public ArrayList<MoveRequest> getCurrentMoves(){return currentMoves;}
    public void setCurrentMoves(ArrayList<MoveRequest> CurrentMoves){currentMoves = CurrentMoves;}

    public String toString()
    {
        String returnString = "+";

        for (int i = 0; i < board[0].length; i++)
        {
            returnString += "-";
        }
        returnString += "+";

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
                    returnString += board[y][x].getUnit().getAttackType().substring(0,1);
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

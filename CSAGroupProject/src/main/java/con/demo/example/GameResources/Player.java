package con.demo.example.GameResources;

//@Author Dhruv

/** 
 * The following is the Player helper class.
 * It represents the player
 * It has a field for the player's id
 * 
 * It also has a constructor, a toString method, and getter's and setter's 
 * **/

public class Player 
{
    private int playerID;

    public Player (int PlayerID)
    {
        this.playerID = PlayerID;
    }

    public int getPlayerID(){return playerID;}

    public void setPlayerID(int PlayerID){this.playerID = PlayerID;}

    public String toString()
    {
        return "player: " + playerID;
    }
}

package con.demo.example.GameResources;

//@Author Dhruv

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

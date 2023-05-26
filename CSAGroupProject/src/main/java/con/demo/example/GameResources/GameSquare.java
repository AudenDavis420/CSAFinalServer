package con.demo.example.GameResources;

//@Author Dhruv


/** 
 * The following is the GameSquare helper class.
 * It represents each square on the game board
 * It has a terrain field which will either be "grass", "sand", or "water"
 * It's unit field might have a unit in it.
 * 
 * It also has a constructor and getter's and setter's 
 * **/


public class GameSquare {
    private String terrain;
    private Unit unit;



    public GameSquare(String Terrain, Unit Unit)
    {
        terrain = Terrain;
         unit = Unit;
        }

    public String getTerrain()
    {
        return terrain;
    }

    public void setTerrain(String Terrain)
    {
        terrain = Terrain;
    }


    public Unit getUnit()
    {
        return unit;
    }

    public void setUnit(Unit Unit)
    {
        unit = Unit;
    }



}

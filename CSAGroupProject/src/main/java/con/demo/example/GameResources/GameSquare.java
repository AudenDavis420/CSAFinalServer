package con.demo.example.GameResources;

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

package con.demo.example.GameResources;

//@Author Auden

public class Vector2 
{   
    private double x;
    private double y;

    public Vector2(double X, Double Y)
    {
        x = X;
        y = Y;
    }

    public double getX(){return x;}
    public double getY(){return y;}

    public void setX(double X){x = X;}
    public void setY(double Y){y = Y;}
    
    public String toString()
    {
        return "( " + x + " , " + y + " )";
    }


}

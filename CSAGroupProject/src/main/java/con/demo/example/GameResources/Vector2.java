package con.demo.example.GameResources;

//@Author Auden

/** 
 * The following is the Vector2 helper class.
 * It represents a point in 2d space
 * it stores a x and y double value
 * 
 * It also has a constructor, a toString method, and getter's and setter's 
 * **/

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

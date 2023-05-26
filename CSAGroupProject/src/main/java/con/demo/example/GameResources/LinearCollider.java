package con.demo.example.GameResources;

//@Author Auden

/** 
 * The following is the LinearCollider helper class.
 * it represent a line for the ColliderManager to use
 * it has a Vector2 start and end field
 * 
 * It also has a constructor, a toString method, and getter's and setter's 
 * **/
public class LinearCollider
{
    private Vector2 start;
    private Vector2 end;

    public LinearCollider(Vector2 Start, Vector2 End){start = Start; end = End;}

    public Vector2 getStart(){return start;}
    public Vector2 getEnd(){return end;}

    public void setStart(Vector2 Start){start = Start;}
    public void setEnd(Vector2 End){end = End;}

    
    public String toString()
    {
        return "Linear Collider: " + start.toString() + " ==> " + end.toString();
    }
}
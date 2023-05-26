package con.demo.example.GameResources;

//@Author Dhruv
//@Author Auden

/** 
 * The following is the MoveRequest helper class.
 * It represents the move from th client that they want to preform
 * It has an field for the start and end x and y values
 * 
 * it also has a field for what type of move it is, a move is either "attack", "move", or "end" (for end turn) 
 * 
 * It also has a constructor, a toString method, and getter's and setter's 
 * **/

public class MoveRequest 
{
    private int startX;
    private int startY;
    private int goalX;
    private int goalY;
    private String moveType;

    public MoveRequest(int sX, int sY, int gX, int gY, String MoveType)
    {
        startX = sX;
        startY = sY;
        goalX = gX;
        goalY = gY;
        moveType = MoveType;
    }

    public int getStartX(){return startX;}
    public int getStartY(){return startY;}
    public int getGoalX(){return goalX;}
    public int getGoalY(){return goalY;}

    public void setStartX(int StartX){startX = StartX;}
    public void setStartY(int StartY){startY = StartY;}
    public void setGoalX(int GoalX){goalX = GoalX;}
    public void setGoalY(int GoalY){goalY = GoalY;}

    public String getMoveType(){return moveType;}

    public void setMoveType(String MoveType){moveType = MoveType;}

    public String toString()
    {
        return moveType + ": (" + startX + ", " + startY + ") ==> (" + goalX + ", " + goalY + ")";
    }
}

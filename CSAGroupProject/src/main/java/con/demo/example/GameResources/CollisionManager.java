package con.demo.example.GameResources;

public class CollisionManager 
{
    
    

    public static Vector2 getCollision(LinearCollider collider1, LinearCollider collider2)
    {
        double xa1 = collider1.getStart().getX();
        double ya1 = collider1.getStart().getY();
        double xa2 = collider1.getEnd().getX();
        double ya2 = collider1.getEnd().getY();


        double xb1 = collider2.getStart().getX();
        double yb1 = collider2.getStart().getY();
        double xb2 = collider2.getEnd().getX();
        double yb2 = collider2.getEnd().getY();

        double sa;
        double sb;

        if (xa1 == xa2)
        {
            sa = 1000.0;
        }
        else
        {
            sa = (ya1-ya2)/(xa1-xa2);
        }

        if (xb1 == xb2)
        {
            sb = 1000.0;
        }
        else
        {
            sb = (yb1-yb2)/(xb1-xb2);
        }

        double ia = ya1 - sa*xa1;
        double ib = yb1 - sb*xb1; 


        double interX = (ia-ib)/(sb-sa);
        double interY = (ia-ib)/(sb-sa)*sa + ia;

        

        if (!isBetweenPoints(collider1.getStart(),collider1.getEnd(),new Vector2(interX,interY)) || !isBetweenPoints(collider2.getStart(),collider2.getEnd(),new Vector2(interX,interY)))
        {
            return null;
        }

        

        return new Vector2(interX, interY);
        

    }


    private static boolean isBetweenPoints(Vector2 point1, Vector2 point2, Vector2 questionPoint)
    {   
        
        if (point1.getX() < point2.getX() && (questionPoint.getX() > point2.getX() || questionPoint.getX() < point1.getX()))
        {
            System.out.println("test");
            return false;
        }
        if (point1.getX() > point2.getX() && (questionPoint.getX() < point2.getX() || questionPoint.getX() > point1.getX()))
        {
            System.out.println("test");
            return false;
        }

        if (point1.getY() < point2.getY() && (questionPoint.getY() > point2.getY() || questionPoint.getY() < point1.getY()))
        {
            System.out.println("test");
            return false;
        }
        if (point1.getY() > point2.getY() && (questionPoint.getY() < point2.getY() || questionPoint.getY() > point1.getY()))
        {
            return false;
        }


        return true;
    }

}

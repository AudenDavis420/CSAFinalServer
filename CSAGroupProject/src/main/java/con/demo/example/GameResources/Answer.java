package con.demo.example.GameResources;



public class Answer {
    private boolean response;

    public static Answer TRUE = new Answer(true);
    public static Answer FALSE = new Answer(false);
    

    public Answer(boolean Response){response = Response;}

    public boolean getResponse(){return response;}
    public void setResponse(boolean Response){response = Response;}

    
}

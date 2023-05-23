package con.demo.example;
import java.util.ArrayList;
import java.util.Hashtable;



import con.demo.example.GameResources.*;

public class GameController
{
    private Game game;

    private Hashtable<String,Integer> unitMobility = new Hashtable<>();

    public GameController(Game game)
    {
        this.game = game;
        unitMobility.put("archer", 2);
        
    }

    public GameController()
    {
        ArrayList<Player> playerList = new ArrayList<>();
        GameSquare[][] board = new GameSquare[10][10];

        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < 10; x++)
            {
                board[y][x] = new GameSquare("grass", null);
            }
        }

        board[1][1] = new GameSquare("sand", new Unit(1, "archer", "ranged", 100, 10, 50, 2,15));


        game = new Game(playerList,board,1);
    }

    public Player addPlayer()
    {
        Player newPlayer = new Player(game.getPlayerList().size() + 1);
        game.getPlayerList().add(newPlayer);
        return newPlayer;
    }

    public Answer startGame(int id)
    {
        if (id != 1){return new Answer(false);}
        System.out.println(game);
        game.setCurrentPlayerTurn(1);
        return new Answer(true);
    }

    public Game getGame(int id)
    {
        return game;
    }

    public Answer makeMove(MoveRequest move, int playerId)
    {
        //if(game.getBoard()[move.getGoalY()][move.getGoalX()] != null && game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit().getTeam() != game.getCurrentPlayerTurn())
        if (playerId != game.getCurrentPlayerTurn()){return Answer.FALSE;}
        if (move.getMoveType().equals("end"))
        {

            for (GameSquare[] row : game.getBoard())
            {
                for (GameSquare square : row)
                {
                    if (square.getUnit() != null){square.getUnit().setMobility(unitMobility.get(square.getClass().getName()));}
                }
            }


            if(game.getCurrentPlayerTurn() == game.getPlayerList().size())
            {
                game.setCurrentPlayerTurn(1);
                return Answer.TRUE;
            }

            game.setCurrentPlayerTurn(game.getCurrentPlayerTurn() + 1);
            return Answer.TRUE;
            
        }
        
        if (move.getMoveType().equals("move"))
        {   
            if(game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit() != null){return Answer.FALSE;}
            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit() == null){return Answer.FALSE;}
            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit().getMobility() <= 0){return Answer.FALSE;}
            if (game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit() != null)
            {
                return Answer.FALSE;
            }
            if (game.getBoard()[move.getStartY()][move.getStartX()].getUnit() == null)
            {
                return Answer.FALSE;
            }
            if(Math.abs(move.getGoalX() - move.getStartX()) > 1 || Math.abs(move.getGoalY()- move.getStartY()) > 1)
            {
                return Answer.FALSE;
            }
            
            game.getBoard()[move.getGoalY()][move.getGoalX()].setUnit( game.getBoard()[move.getStartY()][move.getStartX()].getUnit() );
            game.getBoard()[move.getStartY()][move.getStartX()].setUnit(null);
            game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit().setMobility(game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit().getMobility()-1);
        }
        
        
        if (move.getMoveType().equals("attack"))
        {
            
        }
        System.out.println(game);
        return Answer.TRUE;
    }

}

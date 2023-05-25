package con.demo.example;
import java.util.ArrayList;
import java.util.Hashtable;


//@Author Auden

import con.demo.example.GameResources.*;

public class GameController
{
    private Game game;

    private Hashtable<String,Integer> unitMobility = new Hashtable<>();

    public GameController(Game game)
    {
        this.game = game;
        unitMobility.put("archer", 2);
        unitMobility.put("barbarian", 2);
        unitMobility.put("giant", 1);
        
    }

    public GameController()
    {
        ArrayList<Player> playerList = new ArrayList<>();
        GameSquare[][] board = new GameSquare[2][2];

        for (int y = 0; y < 2; y++)
        {
            for (int x = 0; x < 2; x++)
            {
                board[y][x] = new GameSquare("grass", null);
            }
        }

        board[0][1] = new GameSquare("sand", new Unit(1, "archer", "ranged", 100, 10, 50, 2,15,2));
        board[0][0] = new GameSquare("sand", new Unit(2, "giant", "melee", 400, 1, 50, 1,50,1));


        
        game = new Game(playerList,board,1);

        unitMobility.put("archer", 2);
        unitMobility.put("barbarian", 2);
        unitMobility.put("giant", 1);
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
        System.out.println(move.getMoveType());
        if (playerId != game.getCurrentPlayerTurn()){return Answer.FALSE;}

        if (move.getMoveType().equals("end"))
        {

            for (GameSquare[] row : game.getBoard())
            {
                for (GameSquare square : row)
                {
                    
                    if (square.getUnit() != null)
                    {
                        System.out.println(unitMobility); 
                        square.getUnit().setMobility(unitMobility.get(square.getUnit().getType()).intValue());
                    }
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
                System.out.println("to far");
                return Answer.FALSE;
            }
            
            game.getBoard()[move.getGoalY()][move.getGoalX()].setUnit( game.getBoard()[move.getStartY()][move.getStartX()].getUnit() );
            game.getBoard()[move.getStartY()][move.getStartX()].setUnit(null);
            game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit().setMobility(game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit().getMobility()-1);
            
            
            return Answer.TRUE;
        }
        
        
        if (move.getMoveType().equals("attack"))
        {
            
            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit() == null){return Answer.FALSE;}
            if(game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit() == null){return Answer.FALSE;}

            Unit attacker = game.getBoard()[move.getStartY()][move.getStartX()].getUnit();
            Unit defender = game.getBoard()[move.getGoalY()][move.getGoalX()].getUnit();
            System.out.println(attacker);
            System.out.println(defender);
            if(attacker.getTeam() == defender.getTeam()){return Answer.FALSE;}
            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit().getAttackType().equals("none"))
            {
                System.out.println("none attack type");
                return Answer.FALSE;

            }
            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit().getAttackType().equals("melee"))
            {
                
                if (Math.abs(move.getGoalX() - move.getStartX()) > 1 || Math.abs(move.getGoalY()- move.getStartY()) > 1)
                {
                    System.out.println("to far");
                    return Answer.FALSE;
                }
                defender.setHealth(defender.getHealth() - attacker.getDamage());
                if (defender.getHealth() <= 0)
                {
                    game.getBoard()[move.getGoalY()][move.getGoalX()].setUnit(null);
                }
                return Answer.TRUE;
            }

            if(game.getBoard()[move.getStartY()][move.getStartX()].getUnit().getAttackType().equals("ranged"))
            {
                
            }
        }
        System.out.println(game);
        game.getCurrentMoves().add(move);
        return Answer.TRUE;
    }

}

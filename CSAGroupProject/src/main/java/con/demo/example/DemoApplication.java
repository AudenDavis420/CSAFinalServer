package con.demo.example;


import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import con.demo.example.GameResources.*;





@SpringBootApplication
@RequestMapping("/game")
@RestController
public class DemoApplication 
{

    GameController gameController = new GameController();
	public static void main(String... args) 
    {
        System.out.println("test");
        SpringApplication.run(DemoApplication.class, args);
    }


	@GetMapping("/exampleUnit")
    public Unit getExampleUnit()
    {
        return new Unit(1, "rifle", "ranged", 100, 10, 50, 1);
    }

    @GetMapping("/examplePlayer")
    public Player getExamplePlayer()
    {
        return new Player(1);
    }

    @GetMapping("/exampleAnswer")
    public Answer getExampleAnswer()
    {
        return new Answer(true);
    }

    @GetMapping("/exampleGameSquare")
    public GameSquare exampleGameSquare()
    {
        return new GameSquare("grass", new Unit(1, "rifle", "ranged", 100, 10, 50, 1));
    }

    @GetMapping("/exampleGame")
    public Game exampleGame()
    {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1));
        playerList.add(new Player(2));
        GameSquare[][] board = new GameSquare[3][3];

        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                board[y][x] = new GameSquare("grass", new Unit(1, "rifle", "ranged", 100, 10, 50, 1));
            }
        }


        return new Game(playerList,board,1);
    }

    @GetMapping("/exampleMoveRequest")
    public MoveRequest exampleMoveRequest()
    {
        return new MoveRequest(1, 2, 3, 4, "move");
    }



    @GetMapping("/joinGame")
    public Player joinGame()
    {
        System.out.println("hello world");
        return gameController.addPlayer();
        
    }

    @GetMapping("/start/{id}")
    public Answer startGame(@PathVariable int id)
    {
        return gameController.startGame(id);
    }

    @GetMapping("/gameMap/{id}")
    public Game getMap(@PathVariable int id)
    {
        return gameController.getGame(id);
    }

    @PostMapping("/makeMove/{id}")
    public Answer makeMove(@PathVariable int id, @RequestBody MoveRequest moveRequest)
    {
        System.out.println(id + ": " + moveRequest.toString());
        
        return gameController.makeMove(moveRequest,id);
        
    }

    



		
	


	
}

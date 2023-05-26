package con.demo.example;

//@Author Auden

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import con.demo.example.GameResources.*;





@SpringBootApplication
@RestController
public class DemoApplication 
{

    GameController gameController = new GameController(); //creates new GameController object
	public static void main(String... args) 
    {
        SpringApplication.run(DemoApplication.class, args); //starts the SpringBoot API
    }


    // GET request to http://<ip>/joinGame
    //called by the client to join the game
    @GetMapping("/joinGame")
    public Player joinGame()
    {
        return gameController.addPlayer(); //calls and returns the gameController's addPlayer method
        
    }


    // GET request to http://<ip>/start/<player id>
    //called by the client to start the game
    @GetMapping("/start/{id}")
    public Answer startGame(@PathVariable int id)
    {
        return gameController.startGame(id);
    } 

    // GET request to http://<ip>/gameMap/<player id>
    //called by the client to get a copy of the game (map, units, # players, and who's turn it is)
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

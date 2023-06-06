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

    @GetMapping("/script/{id}")
    public String getScript(@PathVariable int id)
    {

        if (id == 1)
        {
            return "As summer approaches, you might try camping in you free time. Here are some tips for camping in the great outdoors.";
        }
        if (id == 2)
        {
            return "Camping is a delightful adventure that brings us closer to nature and allows us to create lasting memories. To ensure a successful and enjoyable outing, let's walk through the ten essential steps of a camping trip.";
        }
        if (id == 3)
        {
            return "Step 1, Planning";
        }
        if (id == 4)
        {
            return "Start by researching your camping destination, checking weather forecasts, and making necessary reservations. Proper planning sets the foundation for a smooth adventure.";
        }
        if (id == 5)
        {
            return "Step 2, Gear Selection";
        }
        if (id == 6)
        {
            return "Choose the right equipment for your camping needs. From tents and sleeping bags to cooking utensils and camping stoves, ensure that you have the essentials to keep you comfortable and well-prepared.  ";
        }
        if (id == 7)
        {
            return "Step 3, Packing";
        }
        if (id == 8)
        {
            return "Efficiently pack your gear, keeping heavy items close to your back and essential items readily accessible. Don't forget to bring a first-aid kit, insect repellent, and plenty of sunscreen.  ";
        }
        if (id == 9)
        {
            return "Step 4, Campsite Selection - Scout the perfect campsite by considering factors like accessibility, proximity to water sources, and level ground for comfortable sleeping. Look for a spot that aligns with your desired camping experience.";
        }
        if (id == 10)
        {
            return "Step 5, Tent Setup";
        }
        if (id == 11)
        {
            return "Follow the instructions to set up your tent properly. Ensure the rainfly is in place and use ground tarps to protect the tent's base. A well-pitched tent guarantees a cozy and dry shelter. ";
        }
        if (id == 12)
        {
            return "Step 6, Campfire Safety";
        }
        if (id == 13)
        {
            return "When building a campfire, choose a safe location away from flammable materials. Keep a bucket of water nearby to extinguish the fire completely before leaving. Remember, ‘Only you can prevent wildfires.’  ";
        }
        if (id == 14)
        {
            return "Step 7, Food Preparation ";
        }
        if (id == 15)
        {
            return "Plan and pack meals that are easy to cook and require minimal cleanup. Consider using a camp stove or grill for convenient cooking, and remember to store your food securely to prevent attracting wildlife.  ";
        }
        if (id == 16)
        {
            return "Step 8, Leave No Trace";
        }
        if (id == 17)
        {
            return "Respect the environment by practicing Leave No Trace principles. Dispose of trash properly, minimize your impact on nature, and leave the campsite cleaner than you found it. ";
        }
        if (id == 18)
        {
            return "Step 9, Enjoy Outdoor Activities";
        }
        if (id == 19)
        {
            return "Take advantage of the natural surroundings by engaging in outdoor activities like hiking, fishing, or wildlife watching. Immerse yourself in the beauty of nature and connect with the outdoors. ";
        }
        if (id == 20)
        {
            return "Step 10, Safety and Preparedness";
        }
        if (id == 21)
        {
            return "Lastly, prioritize safety by being aware of potential hazards and having a plan in case of emergencies. Familiarize yourself with basic first-aid techniques and carry a map and compass for navigation.";
        }
        if (id == 22)
        {
            return "In conclusion, by following these ten tips, you'll set yourself up for a fantastic camping experience. From planning and gear selection to campfire safety and outdoor enjoyment, each step is essential in creating lasting memories and a deep appreciation for nature. So, embrace the great outdoors, cherish the tranquility of the wilderness, and embark on a memorable camping journey. Thank you, and happy camping! ";
        }
        
        

        return "-none-";
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

package sg.edu.nus.iss.workshop16SimpleVer;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.workshop16SimpleVer.Models.Game;
import sg.edu.nus.iss.workshop16SimpleVer.Repo.GameRepository;
import sg.edu.nus.iss.workshop16SimpleVer.Services.GameService;

@SpringBootApplication
public class Workshop16SimpleVerApplication {

	@Autowired
	GameService gService;

	@Autowired
	GameRepository gRepo;

	public static void main(String[] args) {
		SpringApplication.run(Workshop16SimpleVerApplication.class, args);
	}


	@Bean
	CommandLineRunner runner (){
		return args -> {
			JsonArray allGames = null;

			FileInputStream file = new FileInputStream("src\\main\\resources\\static\\bgg\\game.json");

			JsonArray games = gService.getData(file);
			
			//List<Game> gameModels = new ArrayList<>();
			//for(jakarta.json.JsonValue g : games){
			//	gameModels.add(gService.convertToModel((JsonObject)g));
				
			//}

			List<Game> gameModels = games.stream().map(x -> gService.convertToModel((JsonObject)x)).toList();
			//gameModels.stream().forEach(System.out::println);
			gameModels.stream().forEach(x->gRepo.save(x));
											
											

			




		};
	}
}
 
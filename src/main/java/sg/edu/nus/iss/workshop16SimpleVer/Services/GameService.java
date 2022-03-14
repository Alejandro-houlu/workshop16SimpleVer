package sg.edu.nus.iss.workshop16SimpleVer.Services;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.workshop16SimpleVer.Models.Game;

@Service
public class GameService {
    
    public JsonArray getData(InputStream is){
        JsonReader reader = Json.createReader(is);
        return reader.readArray();
    }

    public Game convertToModel(JsonObject jsonGameObj){

        Game game = new Game(
            jsonGameObj.getInt("gid"),
            jsonGameObj.getString("name"),
            jsonGameObj.getInt("year"),
            jsonGameObj.getInt("ranking"),
            jsonGameObj.getInt("users_rated"),
            jsonGameObj.getString("url"),
            jsonGameObj.getString("image")
        );

        return game;


    }
}

package sg.edu.nus.iss.workshop16SimpleVer.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop16SimpleVer.Models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, String> {
    
}

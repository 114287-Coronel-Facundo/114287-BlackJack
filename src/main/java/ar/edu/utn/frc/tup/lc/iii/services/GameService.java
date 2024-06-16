package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.GameDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    GameDTO createGame(GameDTO gameDTO);
    GameDTO getGameById(Long id);
    List<GameDTO> getAllGames();
    void deleteGame(Long id);
}

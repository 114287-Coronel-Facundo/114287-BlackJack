package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    PlayerDTO createPlayer(PlayerDTO playerDTO);
    PlayerDTO getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
    void deletePlayer(Long id);
}

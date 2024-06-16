package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.GameDTO;
import ar.edu.utn.frc.tup.lc.iii.entities.GameEntity;
import ar.edu.utn.frc.tup.lc.iii.repositories.GameRepository;
import ar.edu.utn.frc.tup.lc.iii.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GameDTO createGame(GameDTO gameDTO) {
        GameEntity game = modelMapper.map(gameDTO, GameEntity.class);
        game = gameRepository.save(game);
        return modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO getGameById(Long id) {
        GameEntity game = gameRepository.findById(id).orElse(null);
        return modelMapper.map(game, GameDTO.class);
    }

    @Override
    public List<GameDTO> getAllGames() {
        return gameRepository.findAll().stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}

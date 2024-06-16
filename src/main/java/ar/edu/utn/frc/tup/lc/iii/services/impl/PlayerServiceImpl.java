package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.PlayerDTO;
import ar.edu.utn.frc.tup.lc.iii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lc.iii.repositories.PlayerRepository;
import ar.edu.utn.frc.tup.lc.iii.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        PlayerEntity player = modelMapper.map(playerDTO, PlayerEntity.class);
        player = playerRepository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        PlayerEntity player = playerRepository.findById(id).orElse(null);
        return modelMapper.map(player, PlayerDTO.class);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

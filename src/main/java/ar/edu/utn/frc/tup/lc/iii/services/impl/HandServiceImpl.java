package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.HandDTO;
import ar.edu.utn.frc.tup.lc.iii.entities.HandEntity;
import ar.edu.utn.frc.tup.lc.iii.repositories.HandRepository;
import ar.edu.utn.frc.tup.lc.iii.services.HandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HandServiceImpl implements HandService {

    @Autowired
    private HandRepository handRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HandDTO createHand(HandDTO handDTO) {
        HandEntity hand = modelMapper.map(handDTO, HandEntity.class);
        hand = handRepository.save(hand);
        return modelMapper.map(hand, HandDTO.class);
    }

    @Override
    public HandDTO getHandById(Long id) {
        HandEntity hand = handRepository.findById(id).orElse(null);
        return modelMapper.map(hand, HandDTO.class);
    }

    @Override
    public List<HandDTO> getAllHands() {
        return handRepository.findAll().stream()
                .map(hand -> modelMapper.map(hand, HandDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHand(Long id) {
        handRepository.deleteById(id);
    }
}

package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.CardDTO;
import ar.edu.utn.frc.tup.lc.iii.entities.CardEntity;
import ar.edu.utn.frc.tup.lc.iii.repositories.CardRepository;
import ar.edu.utn.frc.tup.lc.iii.services.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CardDTO createCard(CardDTO cardDTO) {
        CardEntity card = modelMapper.map(cardDTO, CardEntity.class);
        card = cardRepository.save(card);
        return modelMapper.map(card, CardDTO.class);
    }

    @Override
    public CardDTO getCardById(Long id) {
        CardEntity card = cardRepository.findById(id).orElse(null);
        return modelMapper.map(card, CardDTO.class);
    }

    @Override
    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream()
                .map(card -> modelMapper.map(card, CardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}

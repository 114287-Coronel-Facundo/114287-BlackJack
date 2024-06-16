package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.DeckDTO;
import ar.edu.utn.frc.tup.lc.iii.entities.DeckEntity;
import ar.edu.utn.frc.tup.lc.iii.repositories.DeckRepository;
import ar.edu.utn.frc.tup.lc.iii.services.DeckService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckServiceImpl implements DeckService {
    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeckDTO createDeck(DeckDTO deckDTO) {
        DeckEntity deck = modelMapper.map(deckDTO, DeckEntity.class);
        deck = deckRepository.save(deck);
        return modelMapper.map(deck, DeckDTO.class);
    }

    @Override
    public DeckDTO getDeckById(Long id) {
        DeckEntity deck = deckRepository.findById(id).orElse(null);
        return modelMapper.map(deck, DeckDTO.class);
    }

    @Override
    public List<DeckDTO> getAllDecks() {
        return deckRepository.findAll().stream()
                .map(deck -> modelMapper.map(deck, DeckDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

}

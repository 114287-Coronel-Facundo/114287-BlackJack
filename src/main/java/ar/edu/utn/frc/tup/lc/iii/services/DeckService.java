package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.DeckDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeckService {
    DeckDTO createDeck(DeckDTO deckDTO);
    DeckDTO getDeckById(Long id);
    List<DeckDTO> getAllDecks();
    void deleteDeck(Long id);
}

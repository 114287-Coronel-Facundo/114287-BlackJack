package ar.edu.utn.frc.tup.lc.iii.controllers;
import ar.edu.utn.frc.tup.lc.iii.dtos.DeckDTO;
import ar.edu.utn.frc.tup.lc.iii.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decks")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<DeckDTO> createDeck(@RequestBody DeckDTO deckDTO) {
        DeckDTO createdDeck = deckService.createDeck(deckDTO);
        return ResponseEntity.ok(createdDeck);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeckDTO> getDeckById(@PathVariable Long id) {
        DeckDTO deck = deckService.getDeckById(id);
        return ResponseEntity.ok(deck);
    }

    @GetMapping
    public ResponseEntity<List<DeckDTO>> getAllDecks() {
        List<DeckDTO> decks = deckService.getAllDecks();
        return ResponseEntity.ok(decks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);
        return ResponseEntity.noContent().build();
    }
}

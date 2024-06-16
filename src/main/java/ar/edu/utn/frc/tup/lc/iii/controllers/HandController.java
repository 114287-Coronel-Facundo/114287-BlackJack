package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.HandDTO;
import ar.edu.utn.frc.tup.lc.iii.services.HandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hands")
public class HandController {
    @Autowired
    private HandService handService;

    @PostMapping
    public ResponseEntity<HandDTO> createHand(@RequestBody HandDTO handDTO) {
        HandDTO createdHand = handService.createHand(handDTO);
        return ResponseEntity.ok(createdHand);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HandDTO> getHandById(@PathVariable Long id) {
        HandDTO hand = handService.getHandById(id);
        return ResponseEntity.ok(hand);
    }

    @GetMapping
    public ResponseEntity<List<HandDTO>> getAllHands() {
        List<HandDTO> hands = handService.getAllHands();
        return ResponseEntity.ok(hands);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHand(@PathVariable Long id) {
        handService.deleteHand(id);
        return ResponseEntity.noContent().build();
    }
}

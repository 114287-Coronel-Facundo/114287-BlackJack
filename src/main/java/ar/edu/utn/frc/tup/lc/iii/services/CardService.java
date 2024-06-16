package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.CardDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {
    CardDTO createCard(CardDTO cardDTO);
    CardDTO getCardById(Long id);
    List<CardDTO> getAllCards();
    void deleteCard(Long id);
}

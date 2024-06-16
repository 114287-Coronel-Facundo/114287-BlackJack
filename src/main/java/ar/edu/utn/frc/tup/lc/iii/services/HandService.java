package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.HandDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HandService {
    HandDTO createHand(HandDTO handDTO);
    HandDTO getHandById(Long id);
    List<HandDTO> getAllHands();
    void deleteHand(Long id);
}

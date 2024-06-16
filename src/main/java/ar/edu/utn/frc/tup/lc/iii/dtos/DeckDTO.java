package ar.edu.utn.frc.tup.lc.iii.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeckDTO {
    private Long id;
    private List<CardDTO> cards;
}

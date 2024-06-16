package ar.edu.utn.frc.tup.lc.iii.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HandDTO {
    private Long id;
    private PlayerDTO player;
    private GameDTO game;
    private List<CardDTO> cards;
    private int totalValue;
}

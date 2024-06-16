package ar.edu.utn.frc.tup.lc.iii.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDTO {
    private Long id;
    private String suit;
    private String value;
    private int rank;
}

package ar.edu.utn.frc.tup.lc.iii.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDTO {
    private Long id;
    private String status;
    private List<HandDTO> hands;
}

package ar.edu.utn.frc.tup.lc.iii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;  // Active, Finished, etc.

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<HandEntity> hands;
}

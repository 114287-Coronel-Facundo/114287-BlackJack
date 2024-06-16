package ar.edu.utn.frc.tup.lc.iii.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int balance;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<HandEntity> hands;
}

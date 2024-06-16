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
public class DeckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL)
    private List<CardEntity> cards;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

}

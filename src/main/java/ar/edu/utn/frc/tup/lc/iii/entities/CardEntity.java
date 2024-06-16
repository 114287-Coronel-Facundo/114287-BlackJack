package ar.edu.utn.frc.tup.lc.iii.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String suit;

    private String value;

    private int rank;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private DeckEntity deck;


}

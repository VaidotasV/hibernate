package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projektas")
public class Projektas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pavadinimas;
    private Integer darbuotojas_id;

    public Projektas(Integer id, String pavadinimas, Integer darbuotojas_id) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.darbuotojas_id = darbuotojas_id;
    }
}

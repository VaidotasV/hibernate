package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "darbuotojas")
public class Darbuotojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vardas;
    private String pavarde;
    private Integer skyrius_id;

    public Darbuotojas(Integer id, String vardas, String pavarde, Integer skyrius_id) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.skyrius_id = skyrius_id;
    }
}

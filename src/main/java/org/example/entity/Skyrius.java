package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "skyrius")
public class Skyrius {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pavadinimas;

    public Skyrius(Integer id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
    }
}

package com.advance.bookit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "titre", nullable = false)
    private String titre;
    @Column(name = "auteur", nullable = false)
    private String auteur;
    @Column(name = "resume", nullable = false)
    private String resume;
    @Column(name = "date_publication", nullable = false)
    private LocalDate datePublication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters et setters
}

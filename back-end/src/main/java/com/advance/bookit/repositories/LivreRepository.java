package com.advance.bookit.repositories;

import com.advance.bookit.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByAuteurContainingIgnoreCase(String auteur);
    List<Livre> findByTitreContainingIgnoreCase(String titre);
    List<Livre> findByTitreContainingIgnoreCaseAndAuteurContainingIgnoreCase(String titre, String auteur);
}

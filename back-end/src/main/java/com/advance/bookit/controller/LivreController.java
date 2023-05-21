package com.advance.bookit.controller;

import com.advance.bookit.entities.Livre;
import com.advance.bookit.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livres")
public class LivreController {
    @Autowired
    private LivreRepository livreRepository;

    @GetMapping("")
    public List<Livre> getLivres() {
        return livreRepository.findAll();
    }

    @PostMapping("")
    public Livre addLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        Livre livreToUpdate = livreRepository.findById(id).orElse(null);
        if (livreToUpdate != null) {
            livreToUpdate.setTitre(livre.getTitre());
            livreToUpdate.setAuteur(livre.getAuteur());
            livreToUpdate.setResume(livre.getResume());
            livreToUpdate.setDatePublication(livre.getDatePublication());
            return livreRepository.save(livreToUpdate);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Livre> getLivre(@PathVariable Long id) {
        return livreRepository.findById(id);
    }

    @GetMapping("/recherche")
    public List<Livre> rechercherLivres(@RequestParam(required = false) String titre,
                                        @RequestParam(required = false) String auteur) {
        System.out.printf(titre+auteur);
        if (titre != null && titre.length()!=0 && auteur != null && auteur.length()!=0) {
            return livreRepository.findByTitreContainingIgnoreCaseAndAuteurContainingIgnoreCase(titre, auteur);
        } else if (titre != null && titre.length()!=0) {
            return livreRepository.findByTitreContainingIgnoreCase(titre);
        } else  {
            return livreRepository.findByAuteurContainingIgnoreCase(auteur);
        }

    }
}

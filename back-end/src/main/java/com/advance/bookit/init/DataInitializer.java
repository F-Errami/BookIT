package com.advance.bookit.init;

import com.advance.bookit.entities.Livre;
import com.advance.bookit.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LivreRepository livreRepository;

    @Autowired
    public DataInitializer(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public void run(String... args) {
        // Add your data initialization logic here
        // For example, you can create and save some books
        Livre livre1 = new Livre(1L,"Title 1", "Author 1", "Summary 1", LocalDate.now());
        Livre livre2 = new Livre(2L,"Title 2", "Author 2", "Summary 2", LocalDate.now());
        livreRepository.save(livre1);
        livreRepository.save(livre2);
    }
}

package com.advance.bookit.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.advance.bookit.entities.Livre;
import com.advance.bookit.repositories.LivreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LivreControllerTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreController livreController;

    @Test
    public void testGetLivres() {
        // Arrange
        Livre livre1 = new Livre();
        Livre livre2 = new Livre();
        List<Livre> expectedLivres = Arrays.asList(livre1, livre2);
        when(livreRepository.findAll()).thenReturn(expectedLivres);

        // Act
        List<Livre> actualLivres = livreController.getLivres();

        // Assert
        assertEquals(expectedLivres, actualLivres);
        verify(livreRepository, times(1)).findAll();
    }

    @Test
    public void testAddLivre() {
        // Arrange
        Livre livre = new Livre();
        when(livreRepository.save(livre)).thenReturn(livre);

        // Act
        Livre addedLivre = livreController.addLivre(livre);

        // Assert
        assertEquals(livre, addedLivre);
        verify(livreRepository, times(1)).save(livre);
    }



}


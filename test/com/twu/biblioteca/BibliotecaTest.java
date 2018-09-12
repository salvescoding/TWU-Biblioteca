package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

class BibliotecaTest {

    private static Biblioteca biblio;
    private static Book book;

    @Before
    public void setUp() {
        biblio = new Biblioteca();
        book = new Book(2, "Paulo", "1678");
    }




}
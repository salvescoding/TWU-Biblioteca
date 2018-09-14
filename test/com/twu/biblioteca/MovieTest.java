package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(1,"Pulp Fiction", "Quentin Tarantino", "1999", 9);
    }

    @Test
    public void movieShouldInitializeCorrectlyWithAllFields() {
        assertEquals("Pulp Fiction", movie.getName());
        assertEquals("Quentin Tarantino", movie.getDirector());
        assertEquals("1999", movie.getYearOfRelease());
        assertEquals(9 , movie.getRating());
    }

    @Test
    public void bookCheckoutShouldReturnFalseWhenInitialized() {
        assertFalse(movie.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnTrueWhenCheckoutBook(){
        movie.checkoutMovie();
        assertTrue(movie.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnFalseWhenReturnBook() {
        movie.returnMovie();
        assertFalse(movie.isCheckout());
    }


}
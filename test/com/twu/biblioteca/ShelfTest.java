package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ShelfTest {

    private Shelf shelf;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        shelf = new Shelf();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void findBookWithIdShouldReturnTheCorrectBook() {
        Book b = new Book(1,"Paulo Coelho", "1999");
        Book result = shelf.findBook(1);
        assertEquals(b.getId(), result.getId());
        assertEquals(b.getAuthor(), result.getAuthor());
        assertEquals(b.getYearPublished(), result.getYearPublished());
    }

    @Test
    public void booksAndMoviesShelfShouldNotBeEmptyWhenInitialized() {
        assertFalse(shelf.listBooks().isEmpty());
        assertFalse(shelf.listMovies().isEmpty());
    }

    @Test
    public void listBooksShouldOnlyReturnAvailableBooks() {
        List<Book> books = shelf.listBooks();
        for (Book book : books) {
            assertFalse(book.isCheckout());
        }
    }

    @Test
    public void returnBooksShouldOnlyReturnCheckoutBooks() {
        List<Book> books = shelf.returnBooks();
        for (Book book : books) {
            assertTrue(book.isCheckout());
        }
    }


    @Test
    public void listMoviesShouldOnlyReturnAvailableMovies() {
        List<Movie> movies = shelf.listMovies();
        for (Movie movie : movies) {
            assertFalse(movie.isCheckout());
        }
    }

    @Test
    public void returnMovioesShouldOnlyReturnCheckoutMovies() {
        List<Movie> movies = shelf.returnMovies();
        for (Movie movie : movies) {
            assertTrue(movie.isCheckout());
        }
    }

    @Test
    public void findMoviekWithIdShouldReturnTheCorrectBook() {
        Movie movieOne = shelf.findMovie(1);
        assertEquals("Pulp Fiction", movieOne.getName());
        assertEquals("Quentin Tarantino", movieOne.getDirector());
        assertEquals("1995", movieOne.getYearOfRelease());
        assertEquals(9, movieOne.getRating());
    }





}
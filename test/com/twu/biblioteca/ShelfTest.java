package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

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
        Book result = shelf.find(1);
        assertEquals(b.getId(), result.getId());
        assertEquals(b.getAuthor(), result.getAuthor());
        assertEquals(b.getYearPublished(), result.getYearPublished());
    }

    @Test
    public void booksShelfShouldNotBeEmptyWhenInitialized() {
        assertFalse(shelf.listBooks().isEmpty());
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


}
package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


import static org.junit.Assert.*;

public class ReturnTest {

    private Return returnBook;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        Shelf shelf = new Shelf();
        returnBook = new Return(shelf);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void findBookShouldReturnTheCorrectObject() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book result = returnBook.findBook(1);
        assertEquals(b1.getId(), result.getId());
        assertEquals(b1.getAuthor(), result.getAuthor());
        assertEquals(b1.getYearPublished(), result.getYearPublished());
    }

    @Test
    public void checkIfBookFoundIsEmptyOrNot() {
        Book book =  returnBook.findBook(1);
        boolean result = returnBook.isBookValid(book);
        assertEquals(true, result);
    }

    @Test
    public void checkoutAvailableBooksShouldOnlyHaveBooksNotCheckout() {
        List<Book> books = returnBook.getBooksToReturn();
        for (Book book : books) {
            assertEquals(true, book.isCheckout());
        }
    }

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutSuccessful() {
        String expected = "\nThank you for returning the book.\n";
        returnBook.printMessage(true);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutUnsuccessful() {
        String expected = "\nThat is not a valid book to return.\n";
        returnBook.printMessage(false);
        assertEquals(expected, outContent.toString());
    }


}
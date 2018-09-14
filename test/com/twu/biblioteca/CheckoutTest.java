package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;


public class CheckoutTest {

    private static Checkout checkout;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUp() {
        Shelf shelf = new Shelf();
        checkout = new Checkout(shelf);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void findBookShouldReturnTheCorrectObject() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book result = checkout.findBook(1);
        assertEquals(b1.getId(), result.getId());
        assertEquals(b1.getAuthor(), result.getAuthor());
        assertEquals(b1.getYearPublished(), result.getYearPublished());
    }

    @Test
    public void isBookValidShouldReturnTrueWhenBookIsValid() {
        Book book =  checkout.findBook(1);
        assertTrue(checkout.isBookValid(book));
    }

    @Test
    public void checkoutAvailableBooksShouldOnlyHaveBooksNotCheckout() {
        List<Book> books = checkout.getAvailableBooks();
        for (Book book : books) {
            assertFalse(book.isCheckout());
        }
    }

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutSuccessful() {
        String expected = "\nThank you! Enjoy the book\n";
        checkout.printMessage(true);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutUnsuccessful() {
        String expected = "\nThat book is not available.\n";
        checkout.printMessage(false);
        assertEquals(expected, outContent.toString());
    }


}

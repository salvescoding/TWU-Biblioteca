package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


import static org.junit.Assert.*;

public class ReturnTest {

    private Return returnItem;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        Shelf shelf = new Shelf();
        /*returnItem = new Return(shelf);*/
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /*@Test
    public void findBookShouldReturnTheCorrectObject() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book result = returnItem.findBook(1);
        assertEquals(b1.getId(), result.getId());
        assertEquals(b1.getAuthor(), result.getAuthor());
        assertEquals(b1.getYearPublished(), result.getYearPublished());
    }

    @Test
    public void checkIfBookFoundIsEmptyOrNot() {
        Book book =  returnItem.findBook(1);
        assertTrue(returnItem.isBookValid(book));
    }

    @Test
    public void checkoutAvailableBooksShouldOnlyHaveBooksNotCheckout() {
        List<Book> books = returnItem.getBooksToReturn();
        for (Book book : books) {
            assertTrue( book.isCheckout());
        }
    }*/

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutSuccessful() {
        String expected = "\nThank you for returning the book.\n";
        returnItem.printMessage(true);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectMessageIfBookWasCheckoutUnsuccessful() {
        String expected = "\nThat is not a valid book to return.\n";
        returnItem.printMessage(false);
        assertEquals(expected, outContent.toString());
    }

    /*@Test
    public void findMovieShouldReturnTheCorrectObject() {
        Movie movieOne = new Movie(1,"Pulp Fiction",
                "Quentin Tarantino",
                "1995",
                9);
        Movie movieFound = returnItem.findMovie(1);
        assertEquals(movieOne.getName(), movieFound.getName());
        assertEquals(movieOne.getDirector(), movieFound.getDirector());
        assertEquals(movieOne.getYearOfRelease(), movieFound.getYearOfRelease());
        assertEquals(movieOne.getRating(), movieFound.getRating());

    }*/



}
package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private static Book book;

    @Before
    public void setUp() {
        book = new Book( "Paulo Coelho", "1989");
    }

    @Test
    public void testIfBookGetsInitializedCorrectly() {
        assertEquals("Paulo Coelho", book.getAuthor());
        assertEquals("1989", book.getYearPublished());
    }


    @Test
    public void bookCheckoutShouldReturnFalseWhenInitialized() {
        assertEquals(false, book.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnTrueWhenCheckoutBook(){
        book.checkoutBook();
        assertEquals(true, book.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnFalseWhenReturnBook() {
        book.returnBook();
        assertEquals(false, book.isCheckout());
    }



}
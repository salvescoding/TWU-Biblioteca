package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private static Book book;

    @Before
    public void setUp() {
        book = new Book( 1,"Paulo Coelho", "1989");
    }

    /*@Test
    public void testIfBookGetsInitializedCorrectly() {
        assertEquals("Paulo Coelho", book.getAuthor());
        assertEquals("1989", book.getYearPublished());
    }

    @Test
    public void bookCheckoutShouldReturnFalseWhenInitialized() {
        assertFalse(book.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnTrueWhenCheckoutBook(){
        book.checkoutBook();
        assertTrue(book.isCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnFalseWhenReturnBook() {
        book.checkoutBook();
        book.returnBook();
        assertFalse(book.isCheckout());
    }

*/

}
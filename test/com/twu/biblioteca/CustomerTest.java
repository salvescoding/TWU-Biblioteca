package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("123-4567",
                "password",
                "salves",
                "salves@mail.com",
                "554594695");
    }

    @Test
    public void customerGetsInitializedCorrectly() {
        assertEquals("123-4567", customer.getLibraryNumber());
        assertEquals("password", customer.getPassword());
        assertEquals("salves", customer.getName());
        assertEquals("salves@mail.com", customer.getEmail());
        assertEquals("554594695", customer.getPhoneNumber());
    }
}
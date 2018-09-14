package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SessionTest {

    private Session session;


    @Before
    public void setUp() throws Exception {
        session = new Session();
    }

    @Test
    public void sessionShouldInitializeWithAPreSetListOfCustomers() {
        assertFalse(session.getCustomers().isEmpty());
    }

    @Test
    public void authenticateShouldVerifyCustomerLibraryNumberAndPassword() {
        assertTrue(session.authenticate("123-4567", "password"));
    }

    @Test
    public void authenticateShouldReturnFalseIfCustomerDetailsAreNotValid() {
        assertFalse(session.authenticate("482-8382", "aksjdiahfå"));
    }

    @Test
    public void afterAuthenticateSessionShouldHoldCurrentCustomerDetails() {
        assertTrue(session.authenticate("123-4567", "password"));
        Customer currentUser = session.getCurrentSession();
        assertEquals("salves", currentUser.getName());
        assertEquals("salves@mail.com", currentUser.getEmail());
        assertEquals("554594695", currentUser.getPhoneNumber());
    }






}
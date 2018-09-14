package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Customer> customers = new ArrayList<Customer>();
    private Input userInput = new Input();
    private Output print = new Output();
    private Customer currentSession = new Customer();

    public Session() {
        createCustomers();
    }

    public boolean login() {
        boolean flag = false;
        String libraryNumber = userInput.getCustomerDetails("Library number");
        String password = userInput.getCustomerDetails("Password");
        if (authenticate(libraryNumber, password)) {
            print.welcomeMessagLogin(getCurrentSession());
            flag = true;
        } else {
            print.incorrectCustomerDetails();
        }
        return flag;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    protected Customer getCurrentSession() {
        return currentSession;
    }

    protected void logout() {
        currentSession = new Customer();
        this.login();
    }



    protected boolean authenticate(String libraryNumber, String password) {
        boolean flag = false;
        for (Customer customerA : customers) {
            if ((customerA.getLibraryNumber().equals(libraryNumber)) && (customerA.getPassword().equals(password))) {
                flag = true;
                currentSession = customerA;
            }
        }
        return flag;
    }

    private void createCustomers() {
        Customer customerone = new Customer("123-4567",
                "password",
                "salves",
                "salves@mail.com",
                "554594695");
        Customer customertwo = new Customer("987-6543",
                "password",
                "juan",
                "juan@mail.com",
                "787655267");
        customers.add(customerone); customers.add(customertwo);
    }


    public void showCustomerDetails() {
        print.showCustomerDetails(getCurrentSession());
    }
}

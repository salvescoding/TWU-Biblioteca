package com.twu.biblioteca;

public class Customer {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public String getLibraryNumber() { return libraryNumber; }

    public void setLibraryNumber(String libraryNumber) { this.libraryNumber = libraryNumber; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Customer(String libraryNumber, String password, String name, String email, String phoneNumber) {
        setLibraryNumber(libraryNumber);
        setPassword(password);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public Customer() {}

    protected boolean isCustomerEmpty() {
        return (getLibraryNumber() == null) &&
                (getPassword() == null) &&
                (getName() == null) &&
                (getEmail() == null) &&
                (getPhoneNumber() == null);
    }
}

package com.twu.biblioteca;

class Book {

    private int id;
    private String author;
    private String yearPublished;
    private boolean checkout;
    private String usernameCheckout;

    public String getUsernameCheckout() { return usernameCheckout; }

    public void setUsernameCheckout(String usernameCheckout) { this.usernameCheckout = usernameCheckout; }

    public int getId() { return this.id; }

    private void setId(int id) { this.id = id; }

    public void returnBook() { setCheckout(false); }

    public void checkoutBook() { setCheckout(true); }

    private void setCheckout(boolean checkout) { this.checkout = checkout; }

    public boolean isCheckout() { return checkout; }

    public String getAuthor() { return author; }

    private void setAuthor(String author) { this.author = author; }

    public String getYearPublished() { return yearPublished; }

    private void setYearPublished(String yearPublished) { this.yearPublished = yearPublished; }


    public Book(int id, String author, String yearPublished) {
        setAuthor(author);
        setYearPublished(yearPublished);
        setId(id);
        this.checkout = false;
    }

    public Book() {}


    public boolean isValid() {
        return getId() != 0 || getAuthor() != null || getYearPublished() != null;
    }
}

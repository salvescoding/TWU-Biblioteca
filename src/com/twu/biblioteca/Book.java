package com.twu.biblioteca;

public class Book {

    private String author;
    private String yearPublished;
    private boolean checkout;
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public void returnBook() { setCheckout(false); }

    public void checkoutBook() { setCheckout(true); }

    private void setCheckout(boolean checkout) { this.checkout = checkout; }

    public boolean isCheckout() { return checkout; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getYearPublished() { return yearPublished; }

    public void setYearPublished(String yearPublished) { this.yearPublished = yearPublished; }


    public Book(String author, String yearPublished) {
        setAuthor(author);
        setYearPublished(yearPublished);
        this.checkout = false;
    }



}

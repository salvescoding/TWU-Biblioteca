package com.twu.biblioteca;

import java.util.List;

public class Checkout {

    private Shelf shelf;
    private Output print = new Output();
    private final Input userInput = new Input();

    public Checkout(Shelf shelf) {
        this.shelf = shelf;
    }

    public void checkoutBook() {
        this.listAvailableBooks();
        int id = userInput.getIdOfBook();
        Book book = findBook(id);
        checkoutBookIfValid(book);
    }

    public void listAvailableBooks() {
        List<Book> books = this.getAvailableBooks();
        printAvailableBooks(books);
    }

    protected List<Book> getAvailableBooks() {
        return this.shelf.listBooks();
    }

    private void printAvailableBooks(List<Book> books) {
        print.headersBooks();
        for (Book book : books) {
            print.printBook(book);
        }
    }

    private void checkoutBookIfValid(Book book) {
        if (isBookValid(book)) {
            book.checkoutBook();
            printMessage(isBookValid(book));
        } else {
            print.bookNotFound();
            printMessage(false);
            this.checkoutBook();
        }
    }

    protected Book findBook(int id) {
        return this.shelf.find(id);
    }

    protected boolean isBookValid(Book book) {
        return book.isValid();
    }

    protected void printMessage(boolean status) {
        if (status) {
            print.successfullCheckout();
        } else {
            print.unsuccessfullCheckout();
        }
    }

}


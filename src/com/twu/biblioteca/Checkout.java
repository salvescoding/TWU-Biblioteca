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
        List<Book> books = getAvailableBooks();
        printAvailableBooks(books);
        int id = userInput.getIdOfBook();
        Book book = findBook(id);
        checkoutBookIfValid(book);
    }

    private List<Book> getAvailableBooks() {
        return this.shelf.listBooks();
    }

    private void printAvailableBooks(List<Book> books) {
        for (Book book : books) {
            print.printBook(book);
        }
    }

    private void checkoutBookIfValid(Book book) {
        if (isBookValid(book)) {
            book.checkoutBook();
            printMessage(isBookValid(book));
        } else {
            printMessage(false);
            this.checkoutBook();
        }
    }

    protected Book findBook(int id) {
        return this.shelf.find(id);
    }

    protected boolean isBookValid(Book book) {
        return !book.isEmpty();
    }

    protected void printMessage(boolean status) {
        if (status) {
            print.successfullCheckout();
        } else {
            print.unsuccessfullCheckout();
        }
    }

}


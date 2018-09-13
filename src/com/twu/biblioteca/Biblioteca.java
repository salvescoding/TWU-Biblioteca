package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    public static List<Book> books = new ArrayList<Book>();
    private final Input userInput = new Input();
    private final Output printer = new Output();

    public void run() {
        printer.welcomeMessage();
        printer.listOptions();
        int userChoice = userInput.getUserInput();
        while (userChoice != 4) {
            action(userChoice);
            printer.listOptions();
            userChoice = userInput.getUserInput();
        }
        goodbyeMessage();
    }



    private void action(int userChoice) {
        switch (userChoice) {
            case 1: listBooks();
                    break;
            case 2: checkoutBook();
                    break;
            case 3: returnBook();
                    break;
            case 4: break;
        }
    }

    private void listBooks() {
        printer.headersBooks();
        for (Book book : books) {
            if (!book.isCheckout()) {
                printer.printBook(book);
            }
        }

    }

    private void checkoutBook() {
        listBooks();
        int bookToCheckout = getIdOfBook();
        Book book = findBook(bookToCheckout);
        checkoutIsBookEmpty(book);
        book.checkoutBook();
        printCheckoutMessageSuccessfullOrUnsuccessfull(book);
    }

    private void returnBook() {
        listCheckoutBooks();
        int bookToReturn = getIdOfBook();
        Book book = findBook(bookToReturn);
        returnIsBookEmpty(book);
        book.returnBook();
        printReturnMessageSuccessfullOrUnsuccessfull(book);
    }

    private void goodbyeMessage() {
        printer.goodBye();
    }

    private void listCheckoutBooks() {
        printer.headersBooks();
        for (Book book : books) {
            if (book.isCheckout()) {
                printer.printBook(book);
            }
        }
    }

    private int getIdOfBook() {
        return userInput.getIdOfBook();
    }

    private void returnIsBookEmpty(Book book) {
        if (book.isEmpty()) {
            printer.bookNotFound();
            this.returnBook();
        }
    }

    private void checkoutIsBookEmpty(Book book) {
        if (book.isEmpty()) {
            printer.bookNotFound();
            this.checkoutBook();
        }
    }

    private void printReturnMessageSuccessfullOrUnsuccessfull(Book book) {
        if (!book.isCheckout()) {
            printer.successfullReturn();
        }
        else {
            printer.unsuccessfullReturn();
        }
    }

    private void printCheckoutMessageSuccessfullOrUnsuccessfull(Book book) {
        if (book.isCheckout()) {
            printer.successfullCheckout();
        }
        else {
            printer.unsuccessfullCheckout();
        }
    }

    private Book findBook(int bookToCheckout) {
        Book bookFound = new Book();
        for (Book book : books) {
            if (book.getId() == bookToCheckout) {
                bookFound = book;
            }
        }
        return bookFound;
    }
}

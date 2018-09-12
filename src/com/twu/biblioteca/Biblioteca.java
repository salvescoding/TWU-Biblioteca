package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Biblioteca {

    private List<Book> books = new ArrayList<Book>();
    private Input userInput = new Input();
    private Output printer = new Output();

    public void run() {
        createBooks();
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

    private void createBooks() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book b2 = new Book(2,"Vladimir Nabokov", "2012");
        Book b3 = new Book(3, "Foster Wallace", "2014");
        books.add(b1); books.add(b2); books.add(b3);
    }

    protected void action(int userChoice) {
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

    private void goodbyeMessage() {
        printer.goodBye();
    }

    private void returnBook() {
        listCheckoutBooks();
        int bookToReturn = getIdOfBook();
        Book book = findBook(bookToReturn);
        returnIfBookIsNotEmpty(book);
        book.returnBook();
        printReturnMessageSuccessfullOrUnsuccessfull(book);
    }

    private int getIdOfBook() {
        return userInput.getIdOfBook();
    }

    private void returnIfBookIsNotEmpty(Book book) {
        if (book.isEmpty()) {
            printer.bookNotFound();
            this.returnBook();
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

    private void listCheckoutBooks() {
        printer.headersBooks();
        for (Book book : books) {
            if (book.isCheckout()) {
                printer.printBook(book);
            }
        }
    }

    private void checkoutBook() {
        listBooks();
        int bookToCheckout = getIdOfBook();
        Book book = findBook(bookToCheckout);
        checkoutIfBookIsNotEmpty(book);
        book.checkoutBook();
        printCheckoutMessageSuccessfullOrUnsuccessfull(book);
    }

    private void printCheckoutMessageSuccessfullOrUnsuccessfull(Book book) {
        if (book.isCheckout()) {
            printer.successfullCheckout();
        }
        else {
            printer.unsuccessfullCheckout();
        }
    }

    private void checkoutIfBookIsNotEmpty(Book book) {
        if (book.isEmpty()) {
            printer.bookNotFound();
            this.checkoutBook();
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

    private void listBooks() {
        printer.headersBooks();
        for (Book book : books) {
            if (!book.isCheckout()) {
                printer.printBook(book);
            }
        }

    }
}

package com.twu.biblioteca;

import com.sun.xml.internal.bind.v2.runtime.property.StructureLoaderBuilder;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Book> books = new ArrayList<Book>();
    private Input userInput = new Input();
    private Output printer = new Output();
    private Book book;

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

    }

    private void createBooks() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book b2 = new Book(2,"Vladimir Nabokov", "2012");
        Book b3 = new Book(3, "Foster Wallace", "2014");
        books.add(b1); books.add(b2); books.add(b3);
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

    private void returnBook() {

    }

    private void checkoutBook() {

    }

    private void listBooks() {
        printer.headersBooks();
        for (Book book : books) {
            printer.printBook(book);
        }

    }
}

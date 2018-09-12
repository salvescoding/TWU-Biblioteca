package com.twu.biblioteca;

public class Output {


    public void welcomeMessage() {
        System.out.println();
        System.out.format("%30s","Welcome to your local Biblioteca");
        System.out.println();
        printDashes();
    }


    public void listOptions() {
        System.out.println();
        System.out.println("Please choose one of the following options");
        System.out.println("1 - List all Books");
        System.out.println("2 - Checkout Book");
        System.out.println("3 - Return Book");
        System.out.println("4 - Quit");
    }


    public void headersBooks() {
        System.out.format("%5s%30s%20s","ID", "Author", "Year Published");
        System.out.println();
    }

    public void printBook(Book book) {
        System.out.format("%5s%30s%20s", book.getId(), book.getAuthor(), book.getYearPublished());
        System.out.println();

    }


    public void successfullCheckout() {
        System.out.println();
        System.out.println("Thank you! Enjoy the book");
    }


    public void unsuccessfullCheckout() {
        System.out.println("That book is not available.");
    }

    public void successfullReturn() {
        System.out.println();
        System.out.println("Thank you for returning the book.");
    }

    public void bookNotFound() {
        System.out.println("Book not found, please try again.");
    }

    public void goodBye() {
        System.out.println();
        System.out.format("%30s","Thank you! We will be looking forward to see you again");
        System.out.println();
        printDashes();
    }

    private void printDashes() {
        for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void unsuccessfullReturn() {
        System.out.println("That is not a valid book to return.");
    }
}

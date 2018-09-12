package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Output {


    public void welcomeMessage() {
        System.out.format("%30s","Welcome to your local Biblioteca");
        System.out.println();
        for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
        System.out.println();
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
        System.out.format("%5s%20s%20s","ID", "Author", "Year Published");
        System.out.println();
    }

    public void printBook(Book book) {
        System.out.format("%5s%20s%20s", book.getId(), book.getAuthor(), book.getYearPublished());
        System.out.println();
    }
}

package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrinterConsole {

    private static Scanner userInput = new Scanner(System.in);
    private static List<Book> allBooks = Book.all();

    public void welcomeMessage() {
        System.out.println("Welcome to your local Biblioteca");
        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void listBooks() {
        System.out.format("%10s%30s", "Author", "Year Published");
        System.out.println();
        for (Book book : allBooks) {
            System.out.format("%10s%20s", book.getAuthor(), book.getYearPublished());
            System.out.println();
        }
    }

    public void getUserInput() {
        int choice = 0;
        while (choice != 2) {
            listOptions();
            System.out.print("Your choice: ");
            if (userInput.hasNext()) {
                choice = userInput.nextInt();
                runOptions(choice);
            }
            else {
                System.out.println("Select a valid option!");
            }
        }
    }

    private void listOptions() {
        System.out.println();
        System.out.println("Please choose one of the following options");
        System.out.println("1 - List all books");
        System.out.println("2 - Quit");
    }

    private void runOptions(int userChoice) {
        switch (userChoice) {
            case 1: listBooks();
                    break;
            case 2: break;
        }
    }
}

package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static Scanner userInput = new Scanner(System.in);

    public int getUserInput() {
        return printGeneralUserInput("Choose the number:  ");
    }

    public int getIdOfBook() {
        return printGeneralUserInput("Please choose the ID of the book: ");
    }

    private int printGeneralUserInput(String print) {
        System.out.println();
        System.out.print(print);

        while (!userInput.hasNextInt()) {
            userInput.next();
            System.out.println("Invalid input! Please introduce a number");
            System.out.print(print);
        }
        return userInput.nextInt();
    }

}

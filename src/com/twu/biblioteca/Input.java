package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    private static Scanner userInput = new Scanner(System.in);

    public int getUserInput() {
        int choice = 0;
        System.out.println();
        System.out.print("Choose the number:  ");
        if (userInput.hasNext()) {
            choice = userInput.nextInt();
        }
        else {
            System.out.println("Select a valid option!");
        }
        return choice;

    }


    public int getIdOfBookToCheckout() {
        int choice = 0;
        System.out.print("Choose the number:  ");
        if (userInput.hasNext()) {
            choice = userInput.nextInt();
        }
        else {
            System.out.println("Select a valid option!");
        }
        return choice;
    }
}

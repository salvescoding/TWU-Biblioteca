package com.twu.biblioteca;

import java.util.Scanner;

class Input {

    private static final Scanner userInput = new Scanner(System.in);

    public int getUserInput() {
        return printGeneralUserInput("Choose the number:  ");
    }

    public int getId() {
        return printGeneralUserInput("Please choose the ID: ");
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



    public String getCustomerDetails(String details) {
        System.out.println();
        System.out.print("Please introduce your " + details + ": ");

        while (!userInput.hasNext()) {
            userInput.next();
            System.out.println("Invalid input! Please introduce your details");
            System.out.print("Please introduce your " + details + ": ");
        }
        return userInput.next();
    }

}

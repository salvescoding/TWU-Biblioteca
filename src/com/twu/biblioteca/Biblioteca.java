package com.twu.biblioteca;

class Biblioteca {


    private final Input userInput = new Input();
    private final Output print = new Output();
    private final Shelf shelf = new Shelf();
    private final Checkout checkout = new Checkout(shelf);
    private final Return returnBook = new Return(shelf);

    public void run() {
        print.welcomeMessage();
        print.listOptions();
        int userChoice = userInput.getUserInput();
        while (userChoice != 4) {
            action(userChoice);
            print.listOptions();
            userChoice = userInput.getUserInput();
        }
        goodbyeMessage();
    }


    private void action(int userChoice) {
        switch (userChoice) {
            case 1: shelf.listBooks();
                    break;
            case 2: checkout.checkoutBook();
                    break;
            case 3: returnBook.returnBook();
                    break;
            case 4: break;
        }
    }


    private void goodbyeMessage() {
        print.goodBye();
    }

}

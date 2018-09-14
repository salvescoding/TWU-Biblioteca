package com.twu.biblioteca;

class Biblioteca {


    private final Input userInput = new Input();
    private final Output print = new Output();
    private final Shelf shelf = new Shelf();
    private final Session session = new Session();
    private final Checkout checkout = new Checkout(shelf);
    private final Return returnBook = new Return(shelf);

    public void run() {
        print.welcomeMessage();
        while (!session.login()) {
            session.login();
        }
        print.listOptions();
        int userChoice = userInput.getUserInput();
        while (!session.getCurrentSession().isCustomerEmpty()) {
            action(userChoice);
            print.listOptions();
            userChoice = userInput.getUserInput();
        }
        goodbyeMessage();
    }


    private void action(int userChoice) {
        switch (userChoice) {
            case 1: checkout.listAvailableBooks();
                    break;
            case 2: checkout.checkoutBook();
                    break;
            case 3: returnBook.returnBook();
                    break;
            case 4: session.showCustomerDetails();
                    break;
            case 5: session.logout();
                    break;
        }
    }


    private void goodbyeMessage() {
        print.goodBye();
    }

}

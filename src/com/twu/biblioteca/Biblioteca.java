package com.twu.biblioteca;

class Biblioteca {


    private final Input userInput = new Input();
    private final Output print = new Output();
    private final Shelf shelf = new Shelf();
    private final Session session = new Session();
    private final Checkout checkout = new Checkout(shelf);
    private final Return returnItem = new Return(shelf);

    public void run() {
        print.welcomeMessage();
        boolean sessionOn = session.login();
        while (!sessionOn) {
            sessionOn = session.login();
        }
        print.listOptions();
        int userChoice = userInput.getUserInput();
        while (!session.getCurrentUser().isCustomerEmpty()) {
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
            case 2: checkout.listAvailableMovies();
                break;
            case 3: checkout.checkoutBook();
                    break;
            case 4: returnItem.returnBook();
                    break;
            case 5: checkout.checkoutMovie();
                    break;
            case 6: returnItem.returnMovie();
                    break;
            case 7: session.showCustomerDetails();
                    break;
            case 8: session.logout();
                    break;
        }
    }


    private void goodbyeMessage() {
        print.goodBye();
    }

}

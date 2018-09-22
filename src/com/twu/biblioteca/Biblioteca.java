package com.twu.biblioteca;

class Biblioteca {


    private final Input userInput = new Input();
    private final Output print = new Output();
    private final Shelf shelf = new Shelf();
    private final Session session = new Session();
    private final Checkout checkout = new Checkout(session);
    private final Return returnItem = new Return(session);

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
            case 1: checkout.listAvailableItems(shelf.getBooks());
                    break;
            case 2: checkout.listAvailableItems(shelf.getMovies());
                break;
            case 3: checkout.checkoutItem(shelf.getBooks());
                    break;
            case 4: returnItem.returnItem(shelf.getBooks());
                    break;
            case 5: checkout.checkoutItem(shelf.getMovies());
                    break;
            case 6: returnItem.returnItem(shelf.getMovies());
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

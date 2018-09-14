package com.twu.biblioteca;


class Output {


    public void welcomeMessage() {
        System.out.println();
        System.out.format("%30s","Welcome to your local Biblioteca");
        System.out.println();
        printDashes();
    }


    public void listOptions() {
        System.out.println();
        System.out.println("Please choose one of the following options");
        System.out.println("1 - List Books");
        System.out.println("2 - List Movies");
        System.out.println("3 - Checkout Book");
        System.out.println("4 - Return Book");
        System.out.println("5 - Checkout Movie");
        System.out.println("6 - Return Movie");
        System.out.println("7 - Show my details");
        System.out.println("8 - Logout");
    }


    public void headersBooks() {
        System.out.format("%5s%30s%20s","ID", "Author", "Year Published");
        System.out.println();
    }

    public void headersMovies() {
        System.out.format("%5s%30s%30s%20s%20s","ID", "Title", "Director", "Year Published", "Rating");
        System.out.println();
    }

    public void printBook(Book book) {
        System.out.format("%5s%30s%20s", book.getId(), book.getAuthor(), book.getYearPublished());
        System.out.println();

    }

    public void printMovie(Movie movie) {
        System.out.format("%5s%30s%30s%20s%20s",movie.getId(),
                movie.getName(), movie.getDirector(), movie.getYearOfRelease(), movie.getRating());
        System.out.println();
    }


    public void successfullCheckout() {
        System.out.println();
        System.out.println("Thank you! Enjoy the book");
    }


    public void unsuccessfullCheckout() {
        System.out.println();
        System.out.println("That book is not available.");
    }

    public void successfullReturn() {
        System.out.println();
        System.out.println("Thank you for returning the book.");
    }

    public void itemNotFound(String item) {
        System.out.println(item + " not found, please try again.");
    }


    public void goodBye() {
        System.out.println();
        System.out.format("%30s","Thank you! We will be looking forward to see you again");
        System.out.println();
        printDashes();
    }

    private void printDashes() {
        System.out.println();
        for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void unsuccessfullReturn() {
        System.out.println();
        System.out.println("That is not a valid book to return.");
    }

    public void welcomeMessagLogin(Customer currentSession) {
        System.out.println("Welcome back " + currentSession.getName() + " :)");
    }

    public void incorrectCustomerDetails() {
        System.out.println("Incorrect details, please try again");
    }

    public void showCustomerDetails(Customer currentSession) {
        System.out.println();
        System.out.format("%5s%30s%20s","Name", "Email", "Phone Number");
        printDashes();
        System.out.format("%5s%30s%20s", currentSession.getName(),
                 currentSession.getEmail(),
                 currentSession.getPhoneNumber());
        System.out.println();
    }

    public void printBookCheckout(Book book) {
        System.out.format("%5s%30s%20s",
                book.getId(),
                book.getAuthor(),
                book.getYearPublished());
        System.out.println();
    }
}

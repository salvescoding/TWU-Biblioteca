package com.twu.biblioteca;

import java.util.List;

public class Checkout {

    private Output print = new Output();
    private final Input userInput = new Input();
    private final Session session;

    public Checkout(Session session) {
        this.session = session;
    }

    public void checkoutItem(List<? extends LibraryItem> itemsList) {
        List<? extends LibraryItem> items = itemsList;
        this.listAvailableItems(items);
        int id = userInput.getId();
        LibraryItem itemFound = findItem(id, itemsList);
        checkoutItemIfValid(itemFound);

    }

    protected void listAvailableItems(List<? extends LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Movie) {
                printAvailableMovies((Movie) item);
            } else if (item instanceof Book) {
                printAvailableBooks((Book) item);
            }
        }
    }

    private void printAvailableBooks(Book item) {
        if (!item.isCheckout()) {
            Book book = item;
            print.printBook(book);
        }
    }

    private void printAvailableMovies(Movie item) {
        if (!item.isCheckout()) {
            Movie movie = item;
            print.printMovie(movie);
        }
    }

    private LibraryItem findItem(int id, List<? extends LibraryItem> itemsList) {
        LibraryItem itemFound = new LibraryItem();
        for (LibraryItem item : itemsList) {
            if (item.getId() == id) {
                itemFound = item;
            }
        }
        return itemFound;
    }

    private void checkoutItemIfValid(LibraryItem itemFound) {
        if (itemFound instanceof Movie) {
            Movie movie = (Movie) itemFound;
            checkoutMovie(movie);
        }  else if (itemFound instanceof Book) {
            Book book = (Book) itemFound;
            checkoutBook(book);
        }

    }

    private void checkoutBook(Book book) {
        if (book.isValid()) {
            book.checkoutItem();
            book.setCheckoutBy(session.getCurrentUser());
            print.successfullCheckout("Book");
        }
    }


    public void checkoutMovie(Movie movie) {
        if (movie.isValid()) {
            movie.checkoutItem();
            movie.setCheckoutBy(session.getCurrentUser());
            print.successfullCheckout("Movie");
        }
    }



}


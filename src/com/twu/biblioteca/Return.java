package com.twu.biblioteca;

import java.util.List;

public class Return {

    private final Session session;
    private final Output print = new Output();
    private final Input userInput = new Input();

    public Return(Session session) { this.session = session; }

    public void returnItem(List<? extends LibraryItem> itemsList) {
        List<? extends LibraryItem> items = itemsList;
        this.listItemsToReturn(items);
    }

    private void listItemsToReturn(List<? extends LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                printBookToReturn(item);
            } else if (item instanceof Movie) {
                printMovieToReturn(item);
            }
        }
    }

    private void printMovieToReturn(LibraryItem item) {
        if (item.isCheckout()) {
            Movie movie = (Movie) item;
            print.printMovie(movie);
        }
    }

    private void printBookToReturn(LibraryItem item) {
        if (item.isCheckout()) {
            Book book = (Book) item;
            print.printBook(book);
        }
    }


    protected void printMessage(boolean status) {
        if (status) {
            print.successfullReturn();
        } else  {
            print.unsuccessfullReturn();
        }
    }
}

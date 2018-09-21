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
        Book book = findBook(id, itemsList);
        checkoutBookIfValid(book);
    }

    private void listAvailableItems(List<? extends LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Movie) {
                Movie movie = (Movie) item;
                print.printMovie(movie);
            } else if (item instanceof Book) {
                Book book = (Book) item;
                print.printBook(book);
            }
        }
    }


    public void checkoutMovie() {
        this.listAvailableMovies();
        int id = userInput.getId();
        Movie movie = findMovie(id);
        checkoutMovieIfValid(movie);
    }

    protected void listAvailableMovies() {
        List<Movie> movies = this.getAvailableMovies();
        printAvailableMovies(movies);
    }

    private void printAvailableMovies(List<Movie> movies) {
        print.headersMovies();
        for (Movie movie : movies) {
            print.printMovie(movie);
        }

    }

    protected void listAvailableBooks() {
        List<Book> books = this.getAvailableBooks();
        printAvailableBooks(books);
    }

    protected List<Book> getAvailableBooks() {
        return this.shelf.listBooks();
    }

    private void printAvailableBooks(List<Book> books) {
        print.headersBooks();
        for (Book book : books) {
            print.printBook(book);
        }
    }

    private void checkoutMovieIfValid(Movie movie) {
        if (isMovieValid(movie)) {
            movie.checkoutItem();
            printMessage(isMovieValid(movie));
        } else {
            print.itemNotFound("Movie");
            printMessage(false);
            this.checkoutMovie();
        }
    }

    private void checkoutBookIfValid(Book book) {
        if (isBookValid(book)) {
            book.checkoutBook();
            printMessage(isBookValid(book));
        } else {
            print.itemNotFound("Book");
            printMessage(false);
            this.checkoutBook();
        }
    }

    protected Book findBook(int id, List<? extends LibraryItem> itemsList) {
        return this.shelf.findBook(id);
    }

    public Movie findMovie(int id) { return this.shelf.findMovie(id); }

    protected boolean isBookValid(Book book) { return book.isValid(); }

    public boolean isMovieValid(Movie movie) { return movie.isValid(); }

    protected void printMessage(boolean status) {
        if (status) {
            print.successfullCheckout();
        } else {
            print.unsuccessfullCheckout();
        }
    }
}


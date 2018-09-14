package com.twu.biblioteca;

import java.util.List;

public class Checkout {

    private Shelf shelf;
    private Output print = new Output();
    private final Input userInput = new Input();

    public Checkout(Shelf shelf) {
        this.shelf = shelf;
    }

    public void checkoutBook() {
        this.listAvailableBooks();
        int id = userInput.getId();
        Book book = findBook(id);
        checkoutBookIfValid(book);
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

    protected List<Movie> getAvailableMovies() { return this.shelf.listMovies(); }

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
            movie.checkoutMovie();
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

    protected Book findBook(int id) {
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


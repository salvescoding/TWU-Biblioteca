package com.twu.biblioteca;

import java.util.List;

public class Return {

    private final Shelf shelf;
    private final Output print = new Output();
    private final Input userInput = new Input();

    public Return(Shelf shelf) {
        this.shelf = shelf;

    }

    public void returnBook() {
        List<Book> booksToReturn = getBooksToReturn();
        printBooksToReturn(booksToReturn);
        int id = userInput.getId();
        Book book = findBook(id);
        returnBookIfValid(book);
    }

    public void returnMovie() {
        List<Movie> moviesToReturn = getMoviesToReturn();
        printMoviesToReturn(moviesToReturn);
        int id = userInput.getId();
        Movie movie = findMovie(id);
        returnMovieIfValid(movie);
    }

    private List<Movie> getMoviesToReturn() {
        return this.shelf.returnMovies();
    }

    protected List<Book> getBooksToReturn() {
        return this.shelf.returnBooks();
    }

    private void printMoviesToReturn(List<Movie> moviesToReturn) {
        print.headersMovies();
        for (Movie movie : moviesToReturn) {
            print.printMovie(movie);
        }
    }

    private void printBooksToReturn(List<Book> booksToReturn) {
        print.headersBooks();
        for (Book book : booksToReturn) {
            print.printBookCheckout(book);
        }
    }



    private void returnBookIfValid(Book book) {
        if (isBookValid(book)) {
            book.returnBook();
            printMessage(isBookValid(book));
        } else {
            print.itemNotFound("Book");
            printMessage(false);
            this.returnBook();
        }
    }

    private void returnMovieIfValid(Movie movie) {
        if (isMovieValid(movie)) {
            movie.returnMovie();
            printMessage(isMovieValid(movie));
        } else {
            print.itemNotFound("Movie");
            this.returnMovie();
        }
    }

    protected Book findBook(int id) {
        return this.shelf.findBook(id);
    }

    protected Movie findMovie(int id) {
        return this.shelf.findMovie(id);
    }

    private boolean isMovieValid(Movie movie) {
        return movie.isValid();
    }

    protected boolean isBookValid(Book book) {
        return book.isValid();
    }

    protected void printMessage(boolean status) {
        if (status) {
            print.successfullReturn();
        } else  {
            print.unsuccessfullReturn();
        }
    }

}

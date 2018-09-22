package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();

    public Shelf() {
        createBooks();
        createMovies();
    }

    protected List<Book> getBooks() { return books; }

    protected List<Movie> getMovies() { return movies; }

    private void createBooks() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book b2 = new Book(2,"Vladimir Nabokov", "2012");
        Book b3 = new Book(3, "Foster Wallace", "2014");
        books.add(b1); books.add(b2); books.add(b3);
    }

    private void createMovies() {
        Movie movieOne = new Movie(1,"Pulp Fiction",
                "Quentin Tarantino",
                "1995",
                9);
        Movie movieTwo = new Movie(2,"The Shawshank Redemption",
                "Frank Darabont",
                "1994",
                10);
        movies.add(movieOne); movies.add(movieTwo);
    }
}

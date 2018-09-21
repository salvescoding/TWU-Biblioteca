package com.twu.biblioteca;

public class Movie extends LibraryItem {

    private String name;
    private String director;
    private int rating;

    public String getName() { return name; }

    public String getDirector() { return director; }

    public int getRating() { return rating; }

    public Movie() { super(); }

    public Movie(int id, String name, String director, String yearOfRelease, int rating) {
        super(id, yearOfRelease);
        this.name = name;
        this.director = director;
        this.rating = rating;
    }



    public boolean isValid() {
        return getId() != 0 && getName() != null &&
                getDirector() != null &&
                getYearOfRelease() != null && getRating() != 0;
    }
}

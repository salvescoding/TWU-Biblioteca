package com.twu.biblioteca;

public class Movie {

    private int id;
    private String name;
    private String director;
    private String yearOfRelease;
    private int rating;
    private boolean checkout;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }

    public String getYearOfRelease() { return yearOfRelease; }

    public void setYearOfRelease(String yearOfRelease) { this.yearOfRelease = yearOfRelease; }

    public int getRating() { return rating; }

    public void setRating(int rating) { this.rating = rating; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void checkoutMovie() { setCheckout(true); }

    public void returnMovie() { setCheckout(false); }

    private void setCheckout(boolean checkout) { this.checkout = checkout; }

    public boolean isCheckout() { return checkout; }

    public Movie(int id, String name, String director, String yearOfRelease, int rating) {
        setId(id);
        setName(name);
        setDirector(director);
        setYearOfRelease(yearOfRelease);
        setRating(rating);
        this.checkout = false;
    }

    public Movie() {
    }

    public boolean isValid() {
        return getId() != 0 && getName() != null &&
                getDirector() != null &&
                getYearOfRelease() != null && getRating() != 0;
    }
}

package com.twu.biblioteca;

class Book extends LibraryItem{


    private String author;

    public String getAuthor() { return author; }


    public Book(int id, String author, String yearPublished) {
        super(id, yearPublished);
        this.author = author;
    }

    public Book() {}


    public boolean isValid() {
        return getId() != 0 || getAuthor() != null || getYearOfRelease() != null;
    }
}

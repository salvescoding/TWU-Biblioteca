package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String author;
    private String yearPublished;
    private static List<Book> allBooks = new ArrayList<Book>();

    public static List<Book> all() {
        return allBooks;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getYearPublished() { return yearPublished; }

    public void setYearPublished(String yearPublished) { this.yearPublished = yearPublished; }

    public Book(String author, String yearPublished) {
        setAuthor(author);
        setYearPublished(yearPublished);
        addBookToAllBooks();
    }

    private void addBookToAllBooks() {
        allBooks.add(this);
    }







}

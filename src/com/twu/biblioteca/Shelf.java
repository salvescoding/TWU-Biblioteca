package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private List<Book> books = new ArrayList<Book>();

    public Shelf() {
        createBooks();
    }

    public Book find(int id) {
        Book bookFound = new Book();
        for (Book book : books) {
            if (book.getId() == id) {
                bookFound = book;
            }
        }
        return bookFound;
    }

    private void createBooks() {
        Book b1 = new Book(1,"Paulo Coelho", "1999");
        Book b2 = new Book(2,"Vladimir Nabokov", "2012");
        Book b3 = new Book(3, "Foster Wallace", "2014");
        books.add(b1); books.add(b2); books.add(b3);
    }

    protected List<Book> listBooks() {
        List<Book> books = new ArrayList<Book>();
        for (Book book : books) {
            if (!book.isCheckout()) {
                books.add(book);
            }
        }
        return books;
    }

    protected List<Book> returnBooks() {
        List<Book> books = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isCheckout()) {
                books.add(book);
            }
        }
        return books;
    }


}

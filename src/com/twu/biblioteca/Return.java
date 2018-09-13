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
        int id = userInput.getIdOfBook();
        Book book = findBook(id);
        returnBookIfValid(book);

    }

    private List<Book> getBooksToReturn() {
        return this.shelf.returnBooks();
    }

    private void printBooksToReturn(List<Book> booksToReturn) {
        for (Book book : booksToReturn) {
            print.printBook(book);
        }
    }

    private void returnBookIfValid(Book book) {
        if (isBookValid(book)) {
            book.returnBook();
            printMessage(isBookValid(book));
        } else {
            printMessage(false);
            this.returnBook();
        }
    }

    protected Book findBook(int id) {
        return this.shelf.find(id);
    }

    protected boolean isBookValid(Book book) {
        return !book.isEmpty();
    }

    protected void printMessage(boolean status) {
        if (status) {
            print.successfullReturn();
        } else  {
            print.unsuccessfullReturn();
        }
    }
}

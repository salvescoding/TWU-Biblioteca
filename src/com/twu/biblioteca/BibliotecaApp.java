package com.twu.biblioteca;


public class BibliotecaApp {

    private static PrinterConsole printer = new PrinterConsole();


    public static void main(String[] args) {
        printer.welcomeMessage();
        Book book1 = new Book("Paulo Coelho", "1997");
        Book book2 = new Book("John Smith", "2013");
        printer.getUserInput();


    }
}

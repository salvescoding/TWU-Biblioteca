package com.twu.biblioteca;

public class LibraryItem {
    private int id;
    private boolean checkout;
    private String yearOfRelease;
    private Customer checkoutBy;

    public int getId() { return id; }

    public boolean isCheckout() { return checkout; }

    public void setCheckout(boolean checkout) { this.checkout = checkout; }

    public void checkoutItem() { setCheckout(true); }

    public void returnItem() { setCheckout(false); }

    public String getYearOfRelease() { return yearOfRelease; }

    public Customer getCheckoutBy() { return checkoutBy; }

    public void setCheckoutBy(Customer checkoutBy) { this.checkoutBy = checkoutBy; }

    public LibraryItem() {
    }

    public LibraryItem(int id, String yearOfRelease) {
        this.id = id;
        this.yearOfRelease = yearOfRelease;
        this.checkout = false;
    }
}

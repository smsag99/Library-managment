package it.polito.library;
public class Book {
    private int id;
    private String title;
    private boolean rented;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean status) {
        this.rented = status;
    }
}
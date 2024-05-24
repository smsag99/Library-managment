package it.polito.library;

public class Reader {
    private int id,numRented = 0;
    private String name, surname;

    public Reader(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }
    public int getNumRented() {
        return numRented;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void increaseNumRented() {
        numRented++;
    }
}
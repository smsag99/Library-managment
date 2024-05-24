package it.polito.library;

import java.util.stream.Collectors;

public class Rental {
    private String bookID;
    private String readerID;
    private String startDate;
    private String endDate = "ONGOING";
    private boolean stillRented;
    private Book book;
    private Reader reader;

    public Rental(String bookID, String readerID, String startDate) throws LibException {

        try {
            book = LibraryManager.books.stream().filter(item -> item.getId() == Integer.parseInt(bookID))
                    .collect(Collectors.toList()).get(0);
            reader = LibraryManager.readers.stream().filter(item -> item.getId() == Integer.parseInt(readerID))
                    .collect(Collectors.toList()).get(0);
            
            LibraryManager.uniqueBooks.put(book.getTitle(), LibraryManager.uniqueBooks.get(book.getTitle()) + 1);
            reader.increaseNumRented();
            if (book.isRented()) {
                throw new LibException("Book is rented");
            }
        } catch (Exception e) {
            throw e;
        }
        book.setRented(true);
        this.bookID = bookID;
        this.readerID = readerID;
        this.startDate = startDate;
        stillRented = true;

    }

    public String getBookID() {
        return bookID;
    }

    public String getReaderID() {
        return readerID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String bookID, String readerID, String endingDate) throws LibException{
        try {
            book = LibraryManager.books.stream().filter(item -> item.getId() == Integer.parseInt(bookID))
                    .collect(Collectors.toList()).get(0);
            reader = LibraryManager.readers.stream().filter(item -> item.getId() == Integer.parseInt(readerID))
                    .collect(Collectors.toList()).get(0);
            if (!book.isRented()) {
                throw new LibException("Book isn't rented");
            }
        } catch (Exception e) {
            throw e;
        }
        this.endDate = endingDate;
        book.setRented(false);
        this.stillRented = false;
    }

    public boolean stillRented() {
        return stillRented;
    }

    public void setStatus(boolean status) {
        stillRented = false;
    }

}

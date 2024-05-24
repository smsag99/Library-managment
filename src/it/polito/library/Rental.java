package it.polito.library;

public class Rental {
    private String bookID;
    private String readerID;
    private String startDate;
    private String endDate;
    private boolean stillRented;;

    public Rental(String bookID, String readerID, String startDate, boolean stillRented) {
        this.bookID = bookID;
        this.readerID = readerID;
        this.startDate = startDate;
        this.stillRented = stillRented;
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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean stillRented() {
        return stillRented;
    }

    public void setStatus(boolean status) {
        stillRented = false;
    }

}

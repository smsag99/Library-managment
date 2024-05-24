package it.polito.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LibraryManager {

	private int booksCountID = 999;
	private int readersCountID = 999;
	private List<Book> books = new ArrayList<>();
	private List<Reader> readers = new ArrayList<>();

	// R1: Readers and Books

	/**
	 * adds a book to the library archive
	 * The method can be invoked multiple times.
	 * If a book with the same title is already present,
	 * it increases the number of copies available for the book
	 * 
	 * @param title the title of the added book
	 * @return the ID of the book added
	 */
	public String addBook(String title) {
		booksCountID++;
		Book book = new Book(booksCountID, title);
		books.add(book);
		return "" + booksCountID;
	}

	/**
	 * Returns the book titles available in the library
	 * sorted alphabetically, each one linked to the
	 * number of copies available for that title.
	 * 
	 * @return a map of the titles liked to the number of available copies
	 */
	public SortedMap<String, Integer> getTitles() {

		return Utility.bookCounter(books);
	}

	/**
	 * Returns the books available in the library
	 * 
	 * @return a set of the titles liked to the number of available copies
	 */
	public Set<String> getBooks() {
		Set<String> uniqueIDs = new TreeSet<>();
		for (Book book : books) {
			uniqueIDs.add("" + book.getId());
		}
		return uniqueIDs;
	}

	/**
	 * Adds a new reader
	 * 
	 * @param name    first name of the reader
	 * @param surname last name of the reader
	 */
	public void addReader(String name, String surname) {
		readersCountID++;
		Reader reader = new Reader(readersCountID, name,surname);
		readers.add(reader);
	}

	/**
	 * Returns the reader name associated to a unique reader ID
	 * 
	 * @param readerID the unique reader ID
	 * @return the reader name
	 * @throws LibException if the readerID is not present in the archive
	 */
	public String getReaderName(String readerID) throws LibException {
		try {
			List<Reader> singleReader = readers.stream().filter(item-> item.getId() == Integer.parseInt(readerID)).collect(Collectors.toList());
			return singleReader.get(0).getName() + " " + singleReader.get(0).getSurname();
		} catch (Exception e) {
			throw new LibException("");
		}
	}

	// R2: Rentals Management

	/**
	 * Retrieves the bookID of a copy of a book if available
	 * 
	 * @param bookTitle the title of the book
	 * @return the unique book ID of a copy of the book or the message "Not
	 *         available"
	 * @throws LibException an exception if the book is not present in the archive
	 */
	public String getAvailableBook(String bookTitle) throws LibException {
		try {
			List<Book> availableBooks = books.stream().filter(item-> item.getTitle().equals(bookTitle)).collect(Collectors.toList());
			return availableBooks.get(0).getId()+"";
		} catch (Exception e) {
			throw new LibException("");
		}
	}

	/**
	 * Starts a rental of a specific book copy for a specific reader
	 * 
	 * @param bookID       the unique book ID of the book copy
	 * @param readerID     the unique reader ID of the reader
	 * @param startingDate the starting date of the rental
	 * @throws LibException an exception if the book copy or the reader are not
	 *                      present in the archive,
	 *                      if the reader is already renting a book, or if the book
	 *                      copy is already rented
	 */
	public void startRental(String bookID, String readerID, String startingDate) throws LibException {
		
	}

	/**
	 * Ends a rental of a specific book copy for a specific reader
	 * 
	 * @param bookID     the unique book ID of the book copy
	 * @param readerID   the unique reader ID of the reader
	 * @param endingDate the ending date of the rental
	 * @throws LibException an exception if the book copy or the reader are not
	 *                      present in the archive,
	 *                      if the reader is not renting a book, or if the book copy
	 *                      is not rented
	 */
	public void endRental(String bookID, String readerID, String endingDate) throws LibException {
	}

	/**
	 * Retrieves the list of readers that rented a specific book.
	 * It takes a unique book ID as input, and returns the readers' reader IDs and
	 * the starting and ending dates of each rental
	 * 
	 * @param bookID the unique book ID of the book copy
	 * @return the map linking reader IDs with rentals starting and ending dates
	 * @throws LibException an exception if the book copy or the reader are not
	 *                      present in the archive,
	 *                      if the reader is not renting a book, or if the book copy
	 *                      is not rented
	 */
	public SortedMap<String, String> getRentals(String bookID) throws LibException {
		return null;
	}

	// R3: Book Donations

	/**
	 * Collects books donated to the library.
	 * 
	 * @param donatedTitles It takes in input book titles in the format "First
	 *                      title,Second title"
	 */
	public void receiveDonation(String donatedTitles) {
	}

	// R4: Archive Management

	/**
	 * Retrieves all the active rentals.
	 * 
	 * @return the map linking reader IDs with their active rentals
	 * 
	 */
	public Map<String, String> getOngoingRentals() {
		return null;
	}

	/**
	 * Removes from the archives all book copies, independently of the title, that
	 * were never rented.
	 * 
	 */
	public void removeBooks() {
	}

	// R5: Stats

	/**
	 * Finds the reader with the highest number of rentals
	 * and returns their unique ID.
	 * 
	 * @return the uniqueID of the reader with the highest number of rentals
	 */
	public String findBookWorm() {
		return null;
	}

	/**
	 * Returns the total number of rentals by title.
	 * 
	 * @return the map linking a title with the number of rentals
	 */
	public Map<String, Integer> rentalCounts() {
		return null;
	}

}

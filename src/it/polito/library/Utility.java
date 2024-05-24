package it.polito.library;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Utility {
    public static SortedMap<String, Integer> bookCounter(List<Book> books) {
        SortedMap<String, Integer>  sortedCount = new TreeMap<>();
        for (Book book : books) {
            String title = book.getTitle();
            sortedCount.put(title, sortedCount.getOrDefault(title, 0) + 1);
        }
        return sortedCount;
    }
    
}

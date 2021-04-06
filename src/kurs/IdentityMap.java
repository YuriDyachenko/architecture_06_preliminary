package kurs;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private Map<Integer, Writer> writerMap = new HashMap<>();
    private Map<Integer, Book> bookMap = new HashMap<>();

    public Writer getWriterById(int id) {
        if (writerMap.containsKey(id)) {
            System.out.println("...getting Writer from the map...");
            return writerMap.get(id);
        };
        Writer writer = new WriterMapper().getById(id);
        if (writer != null) putWriter(writer);
        return writer;
    }

    public void putWriter(Writer writer) {
        writerMap.put(writer.getId(), writer);
    }

    public Book getBookById(int id) {
        if (bookMap.containsKey(id)) {
            System.out.println("...getting Book from the map...");
            return bookMap.get(id);
        };
        Book book = new BookMapper().getById(id);
        if (book != null) putBook(book);
        return book;
    }

    public void putBook(Book book) {
        bookMap.put(book.getId(), book);
    }

}

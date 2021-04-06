package kurs;

public class Book {
    private Writer writer;
    private int id;
    private String name;
    private int unread;

    public Book(Writer writer, int id, String name, int unread) {
        this.writer = writer;
        this.id = id;
        this.name = name;
        this.unread = unread;
    }

    public Writer getWriter() {
        return writer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnread() {
        return unread;
    }

    @Override
    public String toString() {
        return "Book{" + writer + ", " + id + ", '" + name + "', " + unread + "}";
    }
}

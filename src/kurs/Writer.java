package kurs;

public class Writer {
    private int id;
    private String name;
    private int unread;

    public Writer(int id, String name, int unread) {
        this.id = id;
        this.name = name;
        this.unread = unread;
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
        return "Writer{" + id + ", '" + name + "', " + unread + "}";
    }
}

package lab2;

public class Book implements Comparable<Book> {

    private final String author;
    private final String name;
    private final int timePublished;

    public Book(String author, String name, int timePublished) {
        this.author = author;
        this.name = name;
        this.timePublished = timePublished;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getTimePublished() {
        return timePublished;
    }

    @Override
    public int compareTo(Book that) {
        if (timePublished == that.timePublished) {
            return name.compareTo(that.name);
        }
        return timePublished - that.timePublished;
    }

    @Override
    public String toString() {
        return "The book "+ name +" by "+ author +" which sold "+ timePublished +" copies";
    }
}

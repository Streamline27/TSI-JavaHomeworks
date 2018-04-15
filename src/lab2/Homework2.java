package lab2;

import java.util.*;

import static lab2.Author.*;

public class Homework2 {
    public static void main(String[] args) {
        Map<String, String> awards = new HashMap<>();

        awards.put(SHAKESPEARE, "Too much drama");
        awards.put(SWIFT, "Survival guide");
        awards.put(AUSTEN, "Did not read");
        awards.put(DUMAS, "Sweet revenge");

        List<Book> books = new ArrayList<>();
        books.add(new Book(SHAKESPEARE,  "Romeo and Juliet", 4500));
        books.add(new Book(DUMAS,  "The Count of Monte Cristo", 1245));
        books.add(new Book(AUSTEN, "Pride and Prejudice", 1000));
        books.add(new Book(SWIFT, "Gulliver's Travels", 1000));
        books.add(new Book(TOLSTOJ, "War and Peace", 1000));

        Collections.sort(books);

        books.forEach(book -> {
            String award = awards.get(book.getAuthor());
            if (award == null) award = "no award";

            System.out.println(book + ", received " + award + " award");
        });

    }
}

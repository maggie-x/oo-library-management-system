package oo.study.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    String name;
    Author author;
    LocalDate publicationDate;
    ArrayList<BookItem> bookItems;

    public Book(String name, String author, String publicationDate) {
        this.name = name;
        this.author = new Author(author);
        this.publicationDate = LocalDate.parse(publicationDate);
        this.bookItems = new ArrayList<>();
    }

    public List<BookItem> getAvailableCopies() {
        return bookItems.stream().filter(BookItem::isAvailable).toList();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author.getName();
    }

    public String getPublicationDate() {
        return publicationDate.toString();
    }

    protected BookItem addBookItem(Rack rack) {
        BookItem newBookItem = new BookItem(this, rack);
        bookItems.add(newBookItem);
        System.out.println("Added " + getName() + " (" + newBookItem.getBarcode() + ") to rack " + rack.getRack());

        return newBookItem;
    }

    public boolean isAvailable() {
        List<BookItem> availableCopies = getAvailableCopies();
        return !availableCopies.isEmpty();
    }

}

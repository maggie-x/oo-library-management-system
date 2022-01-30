package oo.study.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogue {
    HashMap<String, BookItem> bookItems;
    List<Book> books;

    public Catalogue() {
        this.bookItems = new HashMap<>();
        this.books = new ArrayList<>();
    }

    public List<Book> search(String searchString, SearchType searchType) {
        return switch (searchType) {
            case BY_AUTHOR -> new SearchByAuthor(this).search(searchString);
            case BY_DATE -> new SearchByPublicationDate(this).search(searchString);
            default -> new SearchByTitle(this).search(searchString);
        };
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public BookItem getItemByBarcode(String barcode) {
        return bookItems.get(barcode);
    }

    protected void addBook(Book book) {
        books.add(book);
    }

}

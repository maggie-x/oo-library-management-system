package oo.study.library;

import java.util.List;

public interface SearchMethod {
    List<Book> search(String searchString);
}

class SearchByTitle implements SearchMethod {
    Catalogue catalogue;

    public SearchByTitle(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public List<Book> search(String searchString) {
        List<Book> books = catalogue.getAllBooks();
        return books.stream().filter(book -> book.getName().contains(searchString)).toList();
    }
}

class SearchByAuthor implements SearchMethod {
    Catalogue catalogue;

    public SearchByAuthor(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public List<Book> search(String searchString) {
        List<Book> books = catalogue.getAllBooks();
        return books.stream().filter(book -> book.getAuthor().contains(searchString)).toList();
    }
}

class SearchByPublicationDate implements SearchMethod {
    Catalogue catalogue;

    public SearchByPublicationDate(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public List<Book> search(String searchString) {
        List<Book> books = catalogue.getAllBooks();
        return books.stream().filter(book -> book.getPublicationDate().contains(searchString)).toList();
    }
}

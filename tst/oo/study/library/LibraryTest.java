package oo.study.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;

    Membership createLibraryMember() {
        Person john = new Person("John", "1 New York St", "098675416123");
        // When
        Membership result = library.registerMember(john);
        return result;
    }

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Should successfully create new member")
    void registerMember() {
        // Given
        Person john = new Person("John", "1 New York St", "098675416123");
        // When
        Membership result = library.registerMember(john);
        // Then
        assertEquals(result.getName(), john.getName(), "Names should be equal");
    }

    @Test
    void leaseBook() {
        // Given
        Membership member = createLibraryMember();
        Book principles = new Book("Principles", "Ray Dalio", "1998-12-03");
        library.addBook(principles);
        BookItem principlesCopyOne = library.addBookItem(principles, new Rack(0));
        // When
        library.leaseBook(principlesCopyOne, member);
        // Then
        assertFalse(principles.isAvailable());
    }

    @Test
    void returnBook() {
    }

    @Test
    void reserveBook() {
    }
}
package oo.study.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    public static double FINE_AMOUNT = 20.0;

    Catalogue catalogue;
    HashMap<String, Membership> members;

    public Library() {
        this.catalogue = new Catalogue();
        this.members = new HashMap<>();
    }

    List<Book> searchCatalogue(String searchString, SearchType searchType) {
        return catalogue.search(searchString, searchType);
    }

    protected Membership registerMember(Person person) {
        Membership newMembership = new Membership(person);
        members.putIfAbsent(newMembership.getBarcode(), newMembership);
        System.out.println("Registered " + person.getName() + " (" + newMembership.getBarcode() + ")");
        return newMembership;
    }

    public Lease leaseBook(BookItem bookItem, Membership member) {
        System.out.println("Lease Book Request Triggered");
        Lease newLease = new Lease(bookItem, member);
        if (bookItem.isAvailable() && member.canLeaseMore()) {
            bookItem.addLease(newLease);
            member.addLease(newLease);
            return newLease;
        } else if (!bookItem.isAvailable()) {
            System.out.println("Current book is not available");
        } else if (!member.canLeaseMore()) {
            System.out.println(member.getName() + " is at their max lease capacity");
        }

        return null;
    }

    public void returnBook(BookItem bookItem, Membership member) {
        Lease lease = bookItem.getLease();
        if (lease.isOverdue()) {
            member.addFine(bookItem, FINE_AMOUNT);
        }
        bookItem.endLease(member);
        bookItem.activateNextReservation();
    }

    public Reservation reserveBook(BookItem bookItem, Membership member) {
        return bookItem.addReservation(member);
    }

    public BarcodeItem scanBarcode(String barcode) {
        BarcodeItem barcodeItem;
        if ((barcodeItem = catalogue.getItemByBarcode(barcode)) != null) {
            return barcodeItem;
        }
        System.out.println("Could not find item with barcode " + barcode);
        return null;
    }

    protected void addBook(Book book) {
        System.out.println("Adding " + book.getName() + " to catalogue.");
        catalogue.addBook(book);
    }

    protected BookItem addBookItem(Book book, Rack rack) {
        return book.addBookItem(rack);
    }

    protected void runJobToFindOverdueBooks() {

    }

}

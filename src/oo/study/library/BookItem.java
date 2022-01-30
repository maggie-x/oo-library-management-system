package oo.study.library;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BookItem extends BarcodeItem {

    Book book;
    Rack rack;
    Queue<Reservation> reservations;
    Lease lease;

    public BookItem(Book book, Rack rack) {
        this.generateNewBarcode();
        this.book = book;
        this.rack = rack;
        this.reservations = new LinkedList<>();
    }

    public Rack getRack() {
        return rack;
    }

    public Book getBook() {
        return book;
    }

    public Lease getLease() {
        return lease;
    }

    public boolean isAvailable() {
        return lease == null && reservations.isEmpty();
    }

    public Lease addLease(Lease lease) {
        if (isAvailable()) {
            this.lease = lease;
            return lease;
        }
        System.out.println(book.getName() + " is currently not available.");
        return null;
    }

    public void endLease(Membership member) {
        if (Objects.deepEquals(member, this.lease.getLeaser())) {
            lease = null;
            member.removeLease(this);
            System.out.println(member.getName() + "'s lease of " + book.getName() + " has finished.");

        } else {
            System.out.println("Cannot end lease as book returned not by original leaser.");
        }
    }

    public Reservation addReservation(Membership member) {
        Reservation newReservation = new Reservation(this, "today", member);
        reservations.add(newReservation);
        return newReservation;
    }
    public boolean hasReservations() {
        return !reservations.isEmpty();
    }

    public void activateNextReservation() {
        if (!hasReservations()) {
            return;
        }
        Reservation nextReservation = reservations.poll();
        Membership nextInLine = nextReservation.getMember();
        BookItem bookItem = nextReservation.getBookItem();
        this.lease = new Lease(bookItem, nextInLine);
        nextInLine.notify(new Notification("Your reserved book is available and has been leased to you"));
    }

}

package oo.study.library;

public class Reservation {

    public BookItem getBookItem() {
        return bookItem;
    }

    BookItem bookItem;
    String reservationDate;

    public Membership getMember() {
        return member;
    }

    Membership member;

    public Reservation(BookItem bookItem, String reservationDate, Membership member) {
        this.bookItem = bookItem;
        this.reservationDate = reservationDate;
        this.member = member;
    }

}

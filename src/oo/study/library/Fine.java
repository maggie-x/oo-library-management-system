package oo.study.library;

public class Fine {
    BookItem bookItem;
    Membership member;
    double amount;

    public Fine(BookItem bookItem, Membership member, double amount) {
        this.bookItem = bookItem;
        this.member = member;
        this.amount = amount;
    }
}

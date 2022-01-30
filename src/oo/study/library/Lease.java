package oo.study.library;

import java.time.LocalDateTime;

public class Lease {
    public static final int DEFAULT_LEASE_DAYS = 20;
    BookItem bookItem;
    LocalDateTime leaseStartDate;
    LocalDateTime leaseEndDate;

    Membership member;

    public Lease(BookItem bookItem, Membership member) {
        this.bookItem = bookItem;
        this.member = member;
        this.leaseStartDate = LocalDateTime.now();
        this.leaseEndDate = this.leaseStartDate.plusDays(DEFAULT_LEASE_DAYS);
    }

    public Membership getLeaser() {
        return member;
    }

    public boolean isOverdue() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.isAfter(leaseEndDate);
    }

    public String getBarcode() {
        return bookItem.getBarcode();
    }

}

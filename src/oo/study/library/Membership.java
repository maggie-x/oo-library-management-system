package oo.study.library;

import java.util.*;
import java.util.Map.Entry;

public class Membership extends BarcodeItem {
    public static int MAX_LEASE_COUNT = 5;
    public static int MAX_LEASE_PERIOD = 10;

    Person member;
    String joinDate;
    HashMap<String, Lease> leases;
    ArrayList<Reservation> reservations;
    ArrayList<Fine> fines;

    public Membership(Person person) {
        this.member = person;
        this.generateNewBarcode();
        this.leases = new HashMap<>();
        this.reservations = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    protected void notify(Notification notification) {
        System.out.println(notification.getMessage());
    }

    public String getName() {
        return this.member.getName();
    }

    public boolean canLeaseMore() {
        return leases.size() < MAX_LEASE_COUNT;
    }

    protected Lease addLease(Lease lease) {
        if (!canLeaseMore()) {
            System.out.println("User has reached lease limit");
            return null;
        }

        leases.putIfAbsent(lease.getBarcode(), lease);
        System.out.println("Leased to " + member.getName());
        return lease;

    }

    protected void removeLease(BookItem bookItem) {
        leases.remove(bookItem.getBarcode());
    }

    public List<Lease> getOverdueBooks() {
        ArrayList<Lease> overdue = new ArrayList<>();

        Set<Entry<String, Lease>> entrySet = leases.entrySet();
        for (Entry<String, Lease> entry : entrySet) {
            Lease lease = entry.getValue();
            if (lease.isOverdue()) {
                overdue.add(lease);
            }
        }
        return overdue;
    }

    public void addFine(BookItem bookItem, double amount) {
        this.fines.add(new Fine(bookItem, this, amount));
    }
}

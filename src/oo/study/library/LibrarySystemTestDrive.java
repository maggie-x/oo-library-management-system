package oo.study.library;

public class LibrarySystemTestDrive {

    public static void main(String[] args) throws Exception {
        Library library = new Library();
        happyPath(library);
    }

    public static void happyPath(Library library) {
        Book principles = new Book("Principles", "Ray Dalio", "1998-12-03");

        library.addBook(principles);
        BookItem principlesCopyOne = library.addBookItem(principles, new Rack(0));

        Person johnSmith = new Person("John Smith", "12 New York St, New York", "1234567890");
        Membership johnSmithMembership = library.registerMember(johnSmith);

        library.leaseBook(principlesCopyOne, johnSmithMembership);

        library.returnBook(principlesCopyOne, johnSmithMembership);
    }
}

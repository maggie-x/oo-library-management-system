package oo.study.library;

public class Person {
    String name;
    String address;
    String driversLicence;

    public Person(String name, String address, String driversLicence) {
        this.name = name;
        this.address = address;
        this.driversLicence = driversLicence;
    }

    public String getName() {
        return name;
    }
}

package nl.jcore.java8workshop.util;

public final class Address {
    private final String street;
    private final int houseNumber;

    public Address(final String street, final int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s", street, houseNumber);
    }
}

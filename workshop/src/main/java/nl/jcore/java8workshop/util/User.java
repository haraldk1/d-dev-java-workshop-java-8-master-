package nl.jcore.java8workshop.util;

import java.util.Optional;

public final class User {
    private final int id;
    private final String name;
    private final int age;
    private final Optional<Address> address;

    public User(final int id, final String name, final int age, final Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = Optional.ofNullable(address);
    }

    public User(final int id, final String name, final int age) {
        this(id, name, age, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasAddress() {
        return address.isPresent();
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

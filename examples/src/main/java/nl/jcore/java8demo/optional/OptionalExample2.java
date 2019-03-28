package nl.jcore.java8demo.optional;

import java.util.Optional;

public class OptionalExample2 {
    public void doSomethingIfPresent(final Optional<String> optString) {
        if (optString.isPresent()) {
            doSomethingWithString(optString.get());
        }
    }

    private void doSomethingWithString(final String str) {
    }
}


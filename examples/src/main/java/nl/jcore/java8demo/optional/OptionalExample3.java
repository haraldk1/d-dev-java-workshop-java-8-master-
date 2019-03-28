package nl.jcore.java8demo.optional;

import java.util.Optional;

public class OptionalExample3 {
    public void doSomethingIfPresent(final Optional<String> optString) {
        optString.ifPresent(this::doSomethingWithString);

        optString
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .ifPresent(this::doSomethingWithString);
    }

    private void doSomethingWithString(final String str) {
    }
}


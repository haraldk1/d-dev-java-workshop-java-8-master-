package nl.jcore.java8demo.optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@RestController
@RequestMapping("/api/1/demo/optional")
public class OptionalExample {
    @RequestMapping
    public void searchTransactions(final Optional<String> terms, final Optional<Instant> fromTime) {
        final Instant reasonableDefaultFromTime = Instant.now().minus(1, ChronoUnit.DAYS);
        search(terms, fromTime.orElse(reasonableDefaultFromTime));
    }

    private void search(final Optional<String> terms, final Instant fromTime) {
    }
}


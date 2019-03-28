package nl.jcore.java8demo.streaming;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamingExample {
    private final class Transaction {
        private final Instant timestamp;

        public Transaction(final Instant timestamp) {
            this.timestamp = timestamp;
        }

        public Instant getTimestamp() {
            return timestamp;
        }
    }

    private final class User {
        private final String name;
        private final int age;
        private final List<Transaction> transactions;

        public User(final String name, final int age) {
            this.name = name;
            this.age = age;
            this.transactions = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean hasTransactions() {
            return !transactions.isEmpty();
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }

    private List<User> getUsers() {
        return new ArrayList<>();
    }

    public List<String> java7StreamingEquivalent() {
        final List<String> result = new ArrayList<>();
        for (final User user : getUsers()) {
            if (user.age >= 18) {
                result.add(user.getName());
            }
            if (result.size() >= 10) {
                break;
            }
        }
        return result;
    }

    public Map<String, Transaction> java7StreamingMapEquivalent() {
        final Map<Long, User> sortedUsers = new TreeMap<>();
        for (final User user : getUsers()) {
            if (user.age >= 18 && user.hasTransactions()) {
                sortedUsers.put(getLastTransaction(user).getTimestamp().toEpochMilli(), user);
            }
        }
        final Map<String, Transaction> result = new HashMap<>();
        final ArrayList<Long> keys = new ArrayList<>(sortedUsers.keySet());
        for (int i = keys.size() - 1; i >= 0; i--) {
            final User user = sortedUsers.get(i);
            result.put(user.getName(), getLastTransaction(user));
            if (result.size() >= 10) {
                break;
            }
        }
        return result;
    }

    public List<String> java8Streaming() {
        return getUsers().stream()
                .filter(u -> u.getAge() >= 18)
                .map(User::getName)
                .limit(10)
                .collect(Collectors.toList());
    }

    public Map<String, Transaction> java8StreamingMap() {
        final Comparator<User> compareLastTransactionTimestamp =
                Comparator.comparingLong(u -> getLastTransaction(u).getTimestamp().toEpochMilli());
        return getUsers().stream()
                .filter(u -> u.getAge() >= 18)
                .filter(User::hasTransactions)
                .sorted(compareLastTransactionTimestamp)
                .limit(10)
                .collect(Collectors.toMap(User::getName, this::getLastTransaction));
    }

    private Transaction getLastTransaction(final User user) {
        return user.transactions.get(user.transactions.size() - 1);
    }
}

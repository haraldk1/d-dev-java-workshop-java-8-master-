package nl.jcore.java8demo.lambdas;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambdas2 {
    public void runnableExample() {
        final Thread thread = new Thread(() -> {
            System.out.println("Running thread now");
            System.out.println("Executing some logic");
            System.out.println("Ending thread");
        });
        thread.start();
    }

    public void consumerExample(final List<Integer> numbers) {
        numbers.forEach((Integer number) -> System.out.println(number));
        numbers.forEach((number) -> System.out.println(number));
        numbers.forEach(number -> System.out.println(number));
        numbers.forEach(System.out::println);
    }

    public List<Integer> streamExample(final List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .filter(i -> i > 10)
                .map(i -> i * 10)
                .collect(Collectors.toList());
    }

    public Optional<String> optionalExample(final String in) {
        return Optional.ofNullable(in)
                .filter(s -> !s.isEmpty())
                .map(s -> "Value: " + s);
    }
}

package nl.jcore.java8demo.streaming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingExecutionPlanExample {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        final List<String> output = numbers.stream()
                .filter(i -> i % 2 == 0)
                .sorted((i1, i2) -> i2.compareTo(i1))
                .map(String::valueOf)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println(output);
    }
}

package nl.jcore.java8demo.streaming;

import java.util.stream.Stream;

public class StreamGoesWrongExample {
    public static void main(String[] args) {
        final Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);

        numbers
                .filter(i -> i % 2 == 0)
                .limit(2)
                .forEach(System.out::println);

        waitAndClarifyWhy();

        try {
            numbers
                    .filter(i -> i % 2 != 0)
                    .limit(2)
                    .forEach(System.out::print);
        } finally {
            System.out.println("Told yah: ");
            sleepSome();
        }
    }

    private static void waitAndClarifyWhy() {
        sleepSome();

        System.out.println();
        System.out.println("This seems alright, but will go horribly wrong!");
        System.out.println();

        sleepSome();
    }

    private static void sleepSome() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("What do we say to the God of ThreadDeath?");
            System.out.println("Not Today!");
        }
    }
}

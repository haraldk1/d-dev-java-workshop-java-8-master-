package nl.jcore.java8demo.lambdas;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@FunctionalInterface
interface MegaFunction {
    String applyAll(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6);
}

public class Lambdas4 {

    public static void main(String[] args) {
        BiFunction<String, Integer, String> concat1 = (s, i) -> concatEverything(s, i);

        BiFunction<String, Integer, String> concat2 = Lambdas4::concatEverything;

        System.out.println(concat1.apply("Java8", 101));
        System.out.println(concat2.apply("Java8", 101));

        MegaFunction mf = Lambdas4::concatEverything;
        System.out.println(mf.applyAll("Java8", 101, 2.0d, "Hi!", new Object(), asList("this", "that")));
    }

    private static <T1, T2> String concatEverything(T1 a, T2 b) {
        return a.toString() + ": " + b.toString();
    }

    private static String concatEverything(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
        return Stream.of(o1, o2, o3, o4, o5, o6)
                .map(Object::toString)
                .map("- "::concat)
                .collect(Collectors.joining("\n", "\n", "\n"));
    }
}

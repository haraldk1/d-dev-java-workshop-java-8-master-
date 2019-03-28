package nl.jcore.java8workshop;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise001Lambda {
    /**
     * Return a Predicate which evaluates whether an input number is even.
     */
    static Predicate<Integer> oldSkoolPredicate() {
//        System.out.println("super geil!!!!");
        
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer i) {
                return i % 2 == 0;
            }
        };
    }

    /**
     * Return a Predicate which evaluates whether an input number is even
     *
     * This method could be (re-)used in lambda calculations everywhere,
     * e.g. numbers.stream().filter(predicateIsEven()).collect();
     */
    static Predicate<Integer> predicateIsEven() {
        /* A number is even when its remainder for modulo 2 (i % 2) is equal to zero. */
        return (final Integer i) -> i % 2 == 0;
       
    }

    /**
     * Return a Function which converts its Integer input to a String
     */
    static Function<Integer, String> functionToString() {
        return x -> x.toString();
    }

    /**
     * Return a Supplier which returns a String containing "Hello Java 8" (without quotes)
     *
     * When we need an object, such as the "Hello Java 8" String, we could pass it around
     * in our code. Using lambdas, we instead pass around a Supplier object, which serves
     * as a factory for these objects. Two advantages:
     * - We can make it create the wanted object many times
     * - It will only start creating the object when executed. If the object is
     * expensive, we can postpone execution untill we absolutely have no choice.
     */
    static Supplier<String> supplier() {
        return ()->"Hello Java 8";

//        return null; //x -> System.out.println("Hello Java 8");
    }

    /**
     * Return a Consumer which prints its String input (nothing else) to System.out
     *
     * When we want to dispatch some object (in this case a String message) off to
     * somewhere (in this case logging to System.out), we can use the Consumer
     * interface to abstract away where we're sending it to.
     */
    static Consumer<String> consumer() {
        return (x) -> System.out.print(x);
        //Consumer<String>  consumer1 = System.out.println("");
        //return consumer1;
    }
}

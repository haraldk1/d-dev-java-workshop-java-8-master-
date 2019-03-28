package nl.jcore.java8demo.lambdas;

public class Lambdas {
    public static void main(final String[] args) {
        final Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing logic...");
            }
        };
        r1.run();

        final Runnable r2 = () -> System.out.println("Executing logic");
        r2.run();
    }
}

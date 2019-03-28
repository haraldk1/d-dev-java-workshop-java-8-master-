package nl.jcore.java8demo.lambdas;

public class Lambdas3 {
    @FunctionalInterface
    interface FuncInt {
        abstract void doStuff();
    }

    abstract class FuncClass {
        abstract void doStuff();
    }

    public static void main(String[] args) {
        acceptFuncInt(() -> {
        });
//        Lambda 's do not work with abstract classes:
//        acceptFuncClass(() -> {
//        });

    }

    private static void acceptFuncInt(final FuncInt funcInt) {
    }

    private static void acceptFuncClass(final FuncClass funcClass) {
    }
}

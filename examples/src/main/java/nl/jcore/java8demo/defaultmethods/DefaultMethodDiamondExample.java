package nl.jcore.java8demo.defaultmethods;

interface A {
    void test();
}

interface B extends A {
    default void test() { System.out.println("B"); }
}

interface C extends A {
    default void test() { System.out.println("C"); }
}

//class D implements B, C {}

class E implements B, C {
    public void test() {
        B.super.test();
    }
}

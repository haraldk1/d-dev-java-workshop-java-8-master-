package nl.jcore.java8demo.parameternames;

import java.lang.reflect.Method;

public class ParameterNamesExample {
    private class Test {
        public void entryMethod(final String testArg1, final String testArg2) { }
    }

    private void getMethodInfo() throws NoSuchMethodException {
        final Method method = Test.class.getDeclaredMethods()[0];
        final int numParameters = method.getParameterCount();
        final String arg0Name = method.getParameters()[0].getName();
        System.out.println(numParameters); // Prints "2"
        System.out.println(arg0Name); // Prints "arg0"
    }
}


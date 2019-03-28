package nl.jcore.java8workshop;

public class WorkshopUtils {
    public static boolean isLambda(final Object obj) {
        return obj.getClass().toString().contains("$$Lambda$");
    }
}

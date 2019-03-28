package nl.jcore.java8workshop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.PrintStream;
import java.util.function.Consumer;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Exercise001LambdaTest {
    @Test
    public void test001OldSkoolSupplier() {
        assertNotNull(Exercise001Lambda.oldSkoolPredicate());
        assertTrue(Exercise001Lambda.oldSkoolPredicate().test(0));
        assertFalse(Exercise001Lambda.oldSkoolPredicate().test(1));
        assertTrue(Exercise001Lambda.oldSkoolPredicate().test(2));
    }

    @Test
    public void test002Predicate() {
        /* Check default. */
        final String method = "predicateIsEven";
        assertNotNull(pleaseImplement(method), Exercise001Lambda.predicateIsEven());

        /* Check for Java < 8 solution. */
        assertTrue(pleaseImplement(method), WorkshopUtils.isLambda(Exercise001Lambda.predicateIsEven()));

        /* Test functionality. */
        assertTrue(Exercise001Lambda.predicateIsEven().test(0));
        assertFalse(Exercise001Lambda.predicateIsEven().test(1));
        assertTrue(Exercise001Lambda.predicateIsEven().test(2));
    }

    @Test
    public void test003Function() {
        /* Check default. */
        final String method = "functionToString";
        assertNotNull(pleaseImplement(method), Exercise001Lambda.functionToString());

        /* Check for Java < 8 solution. */
        assertTrue(pleaseImplement(method), WorkshopUtils.isLambda(Exercise001Lambda.functionToString()));

        /* Test functionality. */
        assertEquals("0", Exercise001Lambda.functionToString().apply(0));
        assertEquals("1", Exercise001Lambda.functionToString().apply(1));
        assertEquals("12", Exercise001Lambda.functionToString().apply(12));
    }

    @Test
    public void test004Supplier() {
        /* Check default. */
        final String method = "supplier";
        assertNotNull(pleaseImplement(method), Exercise001Lambda.supplier());

        /* Check for Java < 8 solution. */
        assertTrue(pleaseImplement(method), WorkshopUtils.isLambda(Exercise001Lambda.supplier()));

        /* Test functionality. */
        assertEquals("Hello Java 8", Exercise001Lambda.supplier().get());
    }

    @Test
    public void test005Consumer() {
        /* Check default. */
        final String method = "consumer";
        assertNotNull(pleaseImplement(method), Exercise001Lambda.consumer());

        /* Check for Java < 8 solution. */
        assertTrue(pleaseImplement(method), WorkshopUtils.isLambda(Exercise001Lambda.consumer()));

        /* Test functionality. */
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        final String input = "FooBar";
        final Consumer<String> consumer = Exercise001Lambda.consumer();
        consumer.accept(input);

        verify(out).print(input);
    }

    private String pleaseImplement(final String methodStringReference) {
        return "Please implement Exercise001Lambda::" + methodStringReference + " using a Lambda";
    }
}

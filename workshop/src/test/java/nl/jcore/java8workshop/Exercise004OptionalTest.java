package nl.jcore.java8workshop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Exercise004OptionalTest {
    @Test
    public void test001Optional() {
        assertEquals(Optional.of("Test"), Exercise004Optional.returnOptional("Test"));
    }

    @Test(expected = NullPointerException.class)
    public void test002OptionalException() {
        Exercise004Optional.returnOptional(null);
    }

    @Test
    public void test003NullSafeOptional() {
        assertEquals(Optional.of("Test"), Exercise004Optional.nullSafeOptional("Test"));
        assertEquals(Optional.empty(), Exercise004Optional.nullSafeOptional(null));
    }

    @Test
    public void test004IsHasValue() {
        assertTrue(Exercise004Optional.hasValue(Optional.of("")));
        assertTrue(Exercise004Optional.hasValue(Optional.of(0)));
        assertFalse(Exercise004Optional.hasValue(Optional.empty()));
    }

    @Test
    public void test005Default() {
        final String value = "VALUE";
        assertEquals(value, Exercise004Optional.getValueOrDefault(Optional.of(value)));
        assertEquals(Exercise004Optional.SENSIBLE_DEFAULT, Exercise004Optional.getValueOrDefault(Optional.empty()));
    }

    @Test
    public void test006NullSafeOptional_EmptyOptionalIfEmptyString() {
        assertEquals(Optional.of("Test"), Exercise004Optional.nullSafeOptional_EmptyOptionalIfEmptyString("Test"));
        assertEquals(Optional.empty(), Exercise004Optional.nullSafeOptional_EmptyOptionalIfEmptyString(null));
        assertEquals(Optional.empty(), Exercise004Optional.nullSafeOptional_EmptyOptionalIfEmptyString(""));
    }

    @Test
    public void test007MultiplyByTwo() {
        assertEquals(Optional.empty(), Exercise004Optional.multiplyByTwo(Optional.empty()));
        test007MultiplyByTwo(-1);
        test007MultiplyByTwo(0);
        test007MultiplyByTwo(1);
        test007MultiplyByTwo(23);
    }

    private void test007MultiplyByTwo(final int num) {
        assertEquals(Optional.of(2 * num), Exercise004Optional.multiplyByTwo(Optional.of(num)));
    }

    @Test
    public void test008IfPresent() {
        test008IfPresent(Optional.of("FooBar"));
        test008IfPresent(Optional.of(""));
        test008IfPresent(Optional.empty());
    }

    private void test008IfPresent(final Optional<String> input) {
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Exercise004Optional.printValue(input);

        if (!input.isPresent()) {
            verifyZeroInteractions(out);
        } else {
            verify(out).print(input.get());
        }
    }
}

package nl.jcore.java8workshop;

import org.junit.Test;

import java.lang.reflect.Parameter;

import static org.junit.Assert.assertEquals;

/**
 * To make the test corresponding to this class pass, add
 * <compilerArgument>-parameters</compilerArgument> and
 * <testCompilerArgument>-parameters</testCompilerArgument>
 * to the configuration node of the maven-compiler-plugin
 * in the parent pom.xml.
 *
 * Note: If this doesn't work, you might need to execute the
 * Maven goal "clean" and run the plugins compiler:compile
 * and compiler:testCompile (as listed in the IntelliJ IDEA
 * "Maven Projects" panel).
 */
public class Exercise002ParameterNamesTest {
    @Test
    public void testReflection() throws NoSuchMethodException {
        final Parameter[] parameters = Exercise002ParameterNamesDto.class.getDeclaredConstructors()[0].getParameters();
        assertEquals("id", parameters[0].getName());
        assertEquals("name", parameters[1].getName());
    }
}

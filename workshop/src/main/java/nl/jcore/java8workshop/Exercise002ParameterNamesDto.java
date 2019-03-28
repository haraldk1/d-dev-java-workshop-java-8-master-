package nl.jcore.java8workshop;

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
public final class Exercise002ParameterNamesDto {
    private final int id;
    private final String name;

    public Exercise002ParameterNamesDto(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

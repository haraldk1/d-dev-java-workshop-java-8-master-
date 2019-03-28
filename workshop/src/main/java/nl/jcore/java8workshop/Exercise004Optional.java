package nl.jcore.java8workshop;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class Exercise004Optional {
    /**
     * Return an Optional holding the value of the String
     * input. The input should never be null.
     *
     * Why wrap a should-not-be-null value in an Optional
     * if it's going to throw a NullPointerException
     * anyway if the object is null? In this way we
     * express that we do not expect a null value and that
     * execution should halt if it does occur. Fail fast.
     */
    static Optional<String> returnOptional(final String input) {
        return Optional.of(input);
    }

    /**
     * Return an Optional holding the value of the String
     * input. The input may be null.
     *
     * In this case we want to use Optional's full
     * potential and wrap the may-be-null value in a
     * holder to express that there might not be a value.
     * The code working with this Optional will have to
     * handle an Optional.empty() appropriately.
     */
    static Optional<String> nullSafeOptional(@Nullable final String input) {
        return Optional.ofNullable(input);
    }

    /**
     * Return a boolean indicating whether the Optional
     * input contains a value (value is present) or null.
     */
    static boolean hasValue(final Optional<Object> input) {
        return input.isPresent();
    }

    static final String SENSIBLE_DEFAULT = "DEFAULT";

    /**
     * Return the String present in the Optional. If no
     * String is present, return SENSIBLE_DEFAULT;
     */
    static String getValueOrDefault(final Optional<String> input) {
        if (input.isPresent())  return input.get();
        else return SENSIBLE_DEFAULT;
    }

    /**
     * Return an Optional holding the value of the String
     * input. If the input String is empty, the Optional
     * should also be empty.
     *
     * Another great thing about the Optional is that we
     * can use filter() and map() functionality with
     * lambdas. The filter(λ) method on an Optional
     * returns either itself or an Optional.empty()
     * depending on the boolean return value of the
     * lambda (λ). Map(λ) returns an Optional wrapping
     * the outcome of the lambda.
     */
    static Optional<String> nullSafeOptional_EmptyOptionalIfEmptyString(@Nullable final String input) {               

        
        Optional<String> value = Optional.ofNullable(input);
        
        value.ifPresent(x -> System.out.println(x));
        //value.ifPresent(this::System.out.println());
        
        return Optional.ofNullable(input)
                .map(String::trim)
                .filter( i -> !i.isEmpty());  
                
//        if (Optional.ofNullable(input).isPresent()) 
//            if ("".equals(input)) return Optional.empty(); 
//            else return Optional.ofNullable(input);        
//        else return Optional.empty();    
        

        
    }

    /**
     * Return an Optional that contains the integer value
     * multiplied by two, if a value was present.
     * Empty Optional in, empty Optional comes out.
     */
    static Optional<Integer> multiplyByTwo(final Optional<Integer> input) {
        
        if (input.isPresent()) 
            return Optional.of(input.get()*2);
        else return input;  
                
    }

    /**
     * Print the value of the optional (nothing else) to
     * System.out if a value is present. If no value is
     * present, do nothing.
     */
    static void printValue(final Optional<String> input) {
        
        //input.ifPresent(System.out.print(input.get());
        
        /*      input
        .filter(i -> !isEmpty())*/

         if (input.isPresent()) System.out.print(input.get());
         
//         input.ifPresent(input.get()::System.out.println());
    }
}

package tutorialFromWebsites;

import java.util.stream.Stream;

/*All those primitive streams work just like regular object streams with the following differences:
Primitive streams use specialized lambda expressions, e.g. IntFunction instead of Function or
IntPredicate instead of Predicate. And primitive streams support the additional terminal aggregate
operations sum() and average()*/

public class ArrayStream {
    public static void main(String[] args) {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.err.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.err.println("forEach: " + s));
    }
}
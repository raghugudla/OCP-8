package izo809.test.diagnostic;

import java.util.stream.Stream;

public class Que37 {

    public static void main(String... args) {
        Stream.iterate(7, i -> i + 1)
                .limit(5)
                .parallel()
                .peek(i -> System.out.println(i))
                .forEachOrdered(i -> System.out.println(i));
    }
}

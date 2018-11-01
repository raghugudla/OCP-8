package izo809.chap7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStremEx2 {

    public static void main(String... args) {

        Stream<List<String>> listStream =
                Stream.generate(
                        () -> Arrays.asList("a", "b", "c", "d", "e"))
                        .limit(2)
                        .unordered();

        listStream//.parallel()
                .flatMap(strings -> strings.stream())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

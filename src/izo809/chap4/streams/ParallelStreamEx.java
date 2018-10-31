package izo809.chap4.streams;

import java.util.Arrays;

public class ParallelStreamEx {

    public static void main(String... args) {
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));
    }
}

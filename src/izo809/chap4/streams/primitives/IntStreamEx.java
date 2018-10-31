package izo809.chap4.streams.primitives;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamEx {

    private static void ex1() {
//		Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");

        List<String> list = Arrays.asList("A", "BB", "CCC");
        double count =
                list.stream()
                        .mapToInt(item -> item.length())
                        .sum();
        System.out.println("count: " + count);
    }

    private static void ex2() {

        List<String> list = Arrays.asList("A", "BB", "CCC");
        double avg =
                list.stream()
                        .mapToInt(item -> item.length())
                        .average()
                        .orElse(0);

        System.out.println("avg: " + avg);
    }

    private static void ex3() {

        IntStream range = IntStream.range(3, 1);
        System.out.println("..." + range.parallel().findFirst().orElse(0));

        IntStream rangeClosed = IntStream.rangeClosed(1, 6);
        rangeClosed.forEach(System.out::println);
    }

    private static void ex4() {

        IntStream range = IntStream.range(1, 5);

        IntSummaryStatistics stat = range.summaryStatistics();
        System.out.println("min: " + stat.getMin());
        System.out.println("max: " + stat.getMax());
        range.forEach(System.out::println);
    }

    private static void ex5() {

        Stream<String> strings = Stream.of("1", "2");

        strings.mapToInt(s -> s.length());
        strings.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ex5();
    }

}

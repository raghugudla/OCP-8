package izo809.chap4.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void filter() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::println); // monkey
    }

    public static void distinct() {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::println); // duck goose
    }

    /**
     * Stream<T> limit(int maxSize)
     * Stream<T> skip(int n)
     */
    public static void limit_skip() {
        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        s.skip(5)
                .limit(2)
                .forEach(System.out::println); // 6 7
    }

    /**
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
     */
    public static void map() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length).forEach(System.out::println); // 6 7 6
    }

    /**
     * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
     */
    public static void flatMap() {
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(l -> Stream.of(l)).forEach(System.out::println);

        List<List<String>> parentList = new ArrayList<>();
        parentList.add(zero);
        parentList.add(one);
        parentList.add(two);

        parentList.stream().flatMap(l -> l.stream()).forEach(System.out::println);
    }

    /**
     * Stream<T> sorted()
     * Stream<T> sorted(Comparator<? super T> comparator)
     */
    public static void sorted() {
        Stream<String> s = Stream.of("B", "C", "A");
        s.sorted().forEach(System.out::println);

        Stream.of("B", "C", "A")
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * Stream<T> peek(Consumer<? super T> action)
     */
    public static void peek() {
        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g"))
                .peek(System.out::println)
                .count(); // grizzly
        System.out.println(count); // 1
    }

    public static void main(String[] args) {
        flatMap();
/*        filter();
        distinct();
        limit_skip();
        map();
        sorted();
        peek();
*/
    }

}

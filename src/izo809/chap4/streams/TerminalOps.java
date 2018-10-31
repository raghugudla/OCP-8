package izo809.chap4.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {

    public static void createStream() {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
        System.out.println("fromArray count: " + fromArray.count());

        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream<String> fromList = list.stream();
        //Stream.of(list);
        System.out.println("fromList count: " + fromList.count());
        Stream<String> fromListParallel = list.parallelStream();

        //Infinite Streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }

    private static void reductions() {
//		count();
//		min_max();
        reduce();
        collect();
    }

    private static void count() {
        // return type is long
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println("count: " + s.count()); // 3
    }

    /**
     * // Optional<T> min(<? super T> comparator)
     * // Optional<T> max(<? super T> comparator)
     */
    private static void min_max() {
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");

        Optional<String> minString = s.min((s1, s2) -> s1.length() - s2.length());
        minString.ifPresent(System.out::println);

        Stream<String> str = Stream.of("monkey", "ape", "bonobo"); // can't use the first stream as it''s closed by min() terminal operation

        Optional<String> maxString = str.max(Comparator.comparingInt(String::length));
        maxString.ifPresent(System.out::println);
    }

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator)
     * T reduce(T identity, BinaryOperator<T> accumulator)
     * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
     */
    private static void reduce() {

        String[] array = new String[]{"w", "o", "l", "f"};
        String result = "";
        for (String s : array) result = result + s;
        System.out.println(result); // wolf

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s, c) -> s + c); //stream.reduce("", String::concat);
        System.out.println(word); // wolf

        System.out.println(
                Stream.of(3, 5, 6)
                        .reduce(1, (a, b) -> a * b)
        );

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::println); // no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90

        System.out.println(Stream.of(3, 5, 6).reduce(1, op, op)); // 90
        Integer integer = Stream.of(3, 5, 6)//.parallel()
                .reduce(0,
                        (a, b) -> {
                            System.out.println(a + " -1sst binary op- " + b);
                            return a + b;
                        },
                        (a, b) -> {
                            System.out.println(a + " -2nd binary op- " + b);
                            return a * b;
                        }
                );
        System.out.println(integer); // 90

        Stream<Integer> empty1 = Stream.empty();
        System.out.println(empty1.reduce(1, op)); // 1
    }

    /**
     * <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
     * <R,A> R collect(Collector<? super T, A, R> collector)
     */
    private static void collect() {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream//.parallel()
                .collect(TreeSet::new,
                        (a, b) -> {
                            System.out.println(a + " -1- " + b);
                            a.add(b);
                        },
                        (a, b) -> { // This part is called if the stream is parallel
                            System.out.println(a + " .2. " + b);
                            a.addAll(b);
                        }
                );
        System.out.println(set); // [f, l, o, w]

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set1 = stream1.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1); // [f, l, o, w]

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        Set<String> set2 = stream2.collect(Collectors.toSet());
        System.out.println(set2);
    }

    private static void non_reductions() {
        findings();
        matchings();
        forEach();
    }

    /**
     * Optional<T> findAny()
     * Optional<T> findFirst()
     */
    private static void findings() {
        // terminate on infinite streams
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println("findAny: " + s.findAny());

        Stream<String> str = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println("findFirst: " + str.findFirst());
    }

    /**
     * boolean anyMatch(Predicate <? super T> predicate)
     * boolean allMatch(Predicate <? super T> predicate)
     * boolean noneMatch(Predicate <? super T> predicate)
     */
    private static void matchings() {

        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false

        // terminate on infinite streams
        Stream<String> infinite = Stream.generate(() -> "chimp");
        System.out.println(infinite.anyMatch(pred)); // true
    }

    private static void forEach() {

        List<String> list = Arrays.asList("monkey", "2", "chimp");

        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
//		createStream();
        reductions();
//		non_reductions();
    }

}

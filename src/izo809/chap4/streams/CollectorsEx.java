package izo809.chap4.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsEx {

    public static void main(String[] args) {
        //basics();
        //map();
        groupings();
        //partitions();
    }

    private static void basics() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", ")); //Collectors.joining()
        System.out.println("1 " + result);

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Double result1 = ohMy1.collect(Collectors.summingDouble(String::length)); //Collectors.averagingInt
        System.out.println("2 " + result1);
    }

    private static void map() {

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map2 = ohMy2.collect(Collectors.toMap(s -> s, String::length));
        System.out.println("1 " + map2);

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map3 = ohMy3.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println("2a " + map3);
        System.out.println("2b " + map3.getClass());

        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map4 =
                ohMy4.collect(
                        Collectors.toMap(String::length,
                                k -> k,
                                (s1, s2) -> s1 + "," + s2,
                                TreeMap::new
                        )
                );
        System.out.println("3 " + map4);
        System.out.println("3a " + map4.getClass());

    }

    private static void groupings() {
        // groupingBy

        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map5 = ohMy5.collect(Collectors.groupingBy(String::length));
        System.out.println("7 " + map5);

        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears", "tigers");
        Map<Integer, Set<String>> map6 =
                ohMy6.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("8 " + map6);

        //mapping
        Stream<String> ohMyC = Stream.of("lions", "tigers", "bears");
        List<Integer> collect = ohMyC.collect(
                Collectors.mapping(String::length, Collectors.toList())
        );
        System.out.println("mapped collection = " + collect);

        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map7 =
                ohMy7.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println("9 " + map7);

        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
        SortedMap<Integer, SortedSet<String>> map8 =
                ohMy8.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
        System.out.println("10 " + map8);

    }

    private static void partitions() {

        //partitioningBy

        Stream<String> ohMy9 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map9 =
                ohMy9.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println("11 " + map9);

        Stream<String> ohMyA = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> mapA =
                ohMyA.collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println("12 " + mapA);

        Stream<String> ohMyB = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> mapB =
                ohMyB.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println("13 " + mapB);

        //mapping

        Stream<String> ohMyC = Stream.of("lions", "tigers", "bears");
        List<Character> collect = ohMyC.collect(
                Collectors.mapping(s -> s.charAt(0), Collectors.toList())
        );

        System.out.println(collect); // {5=Optional[b], 6=Optional[t]}

    }
}

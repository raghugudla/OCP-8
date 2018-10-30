package izo809.chap3.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapEx {

    public static void main(String[] args) {
        putIfAbsent();
        merge();
        computeIfPresent();
        computeIfAbsent();
    }

    private static void putIfAbsent() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.put(null, "Bus");

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        favorites.putIfAbsent(null, "Tram");
        favorites.putIfAbsent("Raghu", "Flight");

        System.out.println("putIfAbsent: " + favorites); // {Tom=Tram, Raghu=Flight, Jenny=Bus Tour}
        System.out.println();
    }

    private static void merge() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus");
        favorites.put("Tom", null);
        favorites.put(null, "Bus");

        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        favorites.merge("Jenny", "Tram", mapper);
        favorites.merge("Tom", "Metro", mapper); // No NPE
        favorites.merge(null, "Metro", mapper); // No NPE
        favorites.merge("Raghu", "Flight", mapper); // No NPE, BiFunction not being called

        System.out.println("merge: " + favorites); // {Tom=Metro, Raghu=Flight, Jenny=Tram}
        System.out.println();
    }

    private static void computeIfPresent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Tom", null);
        counts.put(null, 3);

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

        Integer jenny = counts.computeIfPresent("Jenny", mapper);
        Integer sam = counts.computeIfPresent("Sam", mapper);
        Integer tom = counts.computeIfPresent("Tom", mapper);
        Integer n = counts.computeIfPresent(null, mapper);

        System.out.println(counts); // {Tom=null, Jenny=2}
        System.out.println(jenny); // 2
        System.out.println(sam); // null
        System.out.println(tom); // null
        System.out.println(n); // 4
    }

    private static void computeIfAbsent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Tom", null);
        counts.put(null, 3);

        Function<String, Integer> mapper = k -> k.length();

        Integer jenny = counts.computeIfAbsent("Jenny", mapper);
        Integer sam = counts.computeIfAbsent("Sam", mapper);
        Integer tom = counts.computeIfAbsent("Tom", mapper);

        System.out.println(counts); // {Tom=3, Jenny=1, Sam=3}
        System.out.println(jenny); // 1
        System.out.println(sam); // 3
        System.out.println(tom); // 3
    }

}

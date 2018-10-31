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
        compute();
    }

    private static void putIfAbsent() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("A", "1");
        favorites.put("B", null);
        favorites.put(null, "3");

        favorites.putIfAbsent("A", "1a");
        favorites.putIfAbsent("B", "2");
        favorites.putIfAbsent(null, "3a");
        favorites.putIfAbsent("D", "4");

        System.out.println("putIfAbsent: " + favorites); //{A=1, B=2, null=3, D=4}
        System.out.println();
    }

    private static void merge() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("A", "1");
        favorites.put("B", null);
        favorites.put(null, "3");

        BiFunction<String, String, String> mapper =
                (v1, v2) -> v2;

        favorites.merge("A", "1a", mapper);
        favorites.merge("B", "2", mapper); // No NPE
        favorites.merge(null, "3a", mapper); // No NPE
        favorites.merge("D", "4", mapper);

        System.out.println("merge: " + favorites); //{A=1a, B=2, null=3a, D=4}
        System.out.println();
    }

    private static void computeIfPresent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("A", 1);
        counts.put("B", null);
        counts.put(null, 3);

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

        System.out.println("A count : " + counts.computeIfPresent("A", mapper)); // 2
        System.out.println("B count : " + counts.computeIfPresent("B", mapper)); // null
        System.out.println("null count : " + counts.computeIfPresent(null, mapper)); // 4
        System.out.println("D count : " + counts.computeIfPresent("D", mapper)); // null

        System.out.println("computeIfPresent : " + counts);
        System.out.println();
    }

    private static void computeIfAbsent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("A", 1);
        counts.put("B", null);
        counts.put(null, 1);

        Function<String, Integer> mapper = k -> k.length() + 1;

        System.out.println("A count : " + counts.computeIfAbsent("A", mapper)); // 1
        System.out.println("B count : " + counts.computeIfAbsent("B", mapper)); // 2
        System.out.println("null count : " + counts.computeIfAbsent(null, mapper)); // 1
        System.out.println("D count : " + counts.computeIfAbsent("D", mapper)); // 2

        System.out.println("computeIfAbsent : " + counts);
        System.out.println();
    }

    private static void compute() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("A", "1");
        favorites.put("B", null);
        favorites.put(null, "3");

        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1 + "," + v2;

        favorites.compute("A", mapper); //A,1
        favorites.compute("B", mapper); //B, null
        favorites.compute(null, mapper); //null,3
        favorites.compute("D", mapper); // D,null

        System.out.println("compute: " + favorites);
        System.out.println();
        System.out.println("favorites = " + favorites.get(null));
    }

}

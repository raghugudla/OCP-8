package izo809.test.diagnostic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Que10 {

    public static void main(String... args) {
        List<String> strings = Arrays.asList("A", "B", "CD", "EF", "GHIJ");

        Map<Integer, String> map = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining()));

        System.out.println("map.values() = " + map.values());
    }
}

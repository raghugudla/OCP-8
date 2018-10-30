package izo809.chap7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReviewQuestions {

    public static void q4() {
        AtomicLong value1 = new AtomicLong(0);
        final long[] value2 = {0};
        IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet());
        IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> ++value2[0]);
        System.out.println(value1 + " " + value2[0]);
    }

    public static void q8() {
        Integer i1 = Arrays.asList(1, 2, 3, 4, 5).stream().findAny().get();
        synchronized (i1) { // y1
            Integer i2 = Arrays.asList(6, 7, 8, 9, 10).parallelStream().sorted() // y2
                    .findAny().get(); // y3
            System.out.println(i1 + " " + i2);
        }
    }

    public static void q13() {
        Stream<String> cats = Stream.of("leopard", "lynx", "ocelot", "puma").parallel();
        Stream<String> bears = Stream.of("panda", "grizzly", "polar").parallel();
        ConcurrentMap<Boolean, List<String>> data = Stream.of(cats, bears)
                .flatMap(s -> s)
                .collect(Collectors.groupingByConcurrent(s -> s.startsWith("p")));
        System.out.println(data.get(false).size() + " " + data.get(true).size());
    }

    public static void main(String[] args) {
        q13();
    }

}

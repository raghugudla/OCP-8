package izo809.chap9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StreamsEx {

    private static void walkStream() throws IOException {
        Path path = Paths.get(".");
        Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
        System.out.println();
    }

    private static void findStream() throws IOException {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 11, 3, 10, 10, 10, 0, ZoneId.of("CET"));
        Path path = Paths.get("src/izo809/chap9");
        Files.find(path, 0,
                (p, a) -> p.toString().endsWith(".java")
                        && a.lastModifiedTime().toInstant().compareTo(zonedDateTime.toInstant()) > 0)
                .forEach(System.out::println);
        System.out.println("done");
        System.out.println();
    }

    private static void list() throws IOException {
        Path path = Paths.get("src");
        Files.list(path).filter(p -> !Files.isDirectory(p)).map(p -> p.toAbsolutePath()).forEach(System.out::println);
    }

    private static void lines() throws IOException {
        Path path = Paths.get("./src/izo809/chap9/StreamsEx.java");
        Files.lines(path).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {

        walkStream();
        findStream();
        list();

        lines();
    }

}

package izo809.chap9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StreamsEx {

    public static void walkStream() throws IOException {
        Path path = Paths.get(".");
        Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
    }

    public static void findStream() throws IOException {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 23, 10, 10, 10, 0, ZoneId.of("CET"));
        Path path = Paths.get(".");
        Files.find(path, 1000,
                (p, a) -> p.toString().endsWith(".java")
                        && a.lastModifiedTime().toInstant().compareTo(zonedDateTime.toInstant()) > 0)
                .forEach(System.out::println);
        System.out.println("done");
    }

    public static void list() throws IOException {
        Path path = Paths.get("./src");
        Files.list(path).filter(p -> !Files.isDirectory(p)).map(p -> p.toAbsolutePath()).forEach(System.out::println);
    }

    public static void lines() throws IOException {
        Path path = Paths.get("./src/izo809/chap9/StreamsEx.java");
        Files.lines(path).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        /*
         * walkStream(); findStream(); list();
         */
        lines();
    }

}

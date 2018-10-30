package izo809.chap4;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ExceptionCaseStudy {

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }

    public static Optional<Integer> calculator(String s) {
        return Optional.ofNullable(s == null ? null : s.length());
    }

    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws IOException {
        ExceptionCaseStudy.create().stream().count();

//		Supplier<List<String>> s = ExceptionCaseStudy::create;
    }

}

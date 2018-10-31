package izo809.chap2;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {

        Consumer<String> c = System.out::println;
        Function<String, String> f = s -> s;
        System.out.println("Main: " + Thread.currentThread().getName());
        Runnable r = () -> {
            System.out.println("Runnable: " + Thread.currentThread().getName());
            c.accept(f.apply("Welcome to functional programming!!!"));
        };
        new Thread(r).start();
        System.out.println("end of main");

        Mother.statMeth();
    }

}

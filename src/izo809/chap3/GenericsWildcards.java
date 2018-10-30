package izo809.chap3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

    public static void main(String[] args) {
        test4();

        List<? super IOException> exceptions = new ArrayList<Exception>();
        //exceptions.add(new Exception()); // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

        List<? super String> strings = new ArrayList<String>();
        //exceptions.add(new Exception()); // DOES NOT COMPILE
        strings.add("A");
        strings.add("B");
    }

    /**
     * Lower-Bounded Wildcards example
     */
    public static void test4() {
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);
        addSound(objects);
    }

    public static void addSound(List<? super String> list) { // lower bound
        list.add("quack");
        System.out.println("list: " + list);
    }

    /**
     * Upper-Bounded Wildcards example
     */
    public static void test3() {

        // Upper-Bounded Wildcards example
        List<? extends Flyer> list = new ArrayList<HangGlider>();
        //list.add(new HangGlider());
        // when we work with upper bounds or unbounded wildcards.
        // The list becomes logically immutable
    }

    /**
     * Upper-Bounded Wildcards example
     */
    public static void test2() {

        // Upper-Bounded Wildcards example
        List<? extends Number> list = new ArrayList<Integer>();
        // list.add(new Integer(arg0)); -->
        // when we work with upper bounds or unbounded wildcards.
        // The list becomes logically immutable
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    /**
     * Unbounded Wildcards
     */
    public static void test1() {

        // Unbounded Wildcards
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        printList(numbers);
    }

    public static void printList(List<?> list) {
        for (Object x : list)
            System.out.println(x);
    }

    interface Flyer {
        void fly();
    }

    class HangGlider implements Flyer {
        public void fly() {
        }
    }

    class Goose implements Flyer {
        public void fly() {
        }
    }
}

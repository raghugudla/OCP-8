package izo809.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsEx {

    public static void main(String[] args) {
        test4();

        List<String> list = Collections.emptyList();
    }

    public static void test4() {

        List<Integer> numbers = Arrays.asList(9, 7, 5, 3);
        Collections.sort(numbers);

        System.out.println("numbers: " + numbers);
        System.out.println(Collections.binarySearch(numbers, 6));
        System.out.println(Collections.binarySearch(numbers, 3));
        System.out.println(Collections.binarySearch(numbers, 7));
    }

    public static void test3() {

        int[] numbers = {6, 9, 1, 8};
        Arrays.sort(numbers);

        System.out.println("numbers: " + numbers);
        System.out.println(Arrays.binarySearch(numbers, 6));
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 7));
    }

    public static void test2() {

        String[] array = {"A", "B"};
        List<String> list = Arrays.asList(array);

        list.set(1, "D");
        array[0] = "C";
        //list.add("E");

        for (String arg : array)
            System.out.println(arg);
        System.out.println("------------------");
    }

    public static void test1() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String[] array = new String[list.size()];
        array[0] = list.get(0);
        array[1] = list.get(1);

        list.add(1, "D");

        for (String arg : array)
            System.out.println(arg);

        for (String arg : list)
            System.out.println(arg);

        System.out.println("------------------");
    }
}

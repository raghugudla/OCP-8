package izo809.chap3.java8;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf_ReplaceAll {

    public static void main(String[] args) {
        replaceAll();
    }

    public static void removeIf() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            numbers.add(i);

        System.out.println("numbers before: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("numbers after: " + numbers);
    }

    public static void replaceAll() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i = i + 2)
            numbers.add(i);

        System.out.println("numbers before: " + numbers);
        numbers.replaceAll(n -> n / 2);
        System.out.println("numbers after: " + numbers);
    }

}

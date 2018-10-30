package izo809.chap3;

import java.util.ArrayList;
import java.util.List;

public class LegacyDragons {
    public static void main(String[] args) {
        List numbers = new ArrayList();
        numbers.add(1);
        printStrings(numbers);
    }

    private static void printStrings(List<String> strings) {
        for (String string : strings) { // ClassCastException
            System.out.println(string);
        }
    }

}

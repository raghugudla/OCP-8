package izo809.chap3;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx implements Comparator<String> {
    public static void main(String[] args) {
        String[] values = {"123", "Abb", "aab"};
        Arrays.sort(values, new ComparatorEx());
        for (String s : values)
            System.out.print(s + " ");
    }

    public int compare(String a, String b) {
        return b.compareTo(a) // aab Abb 123
                //a.toLowerCase().compareTo(b.toLowerCase()) -> 123 aab Abb
                //a.compareTo(b) -> 123 Abb aab
                //b.toLowerCase().compareTo(a.toLowerCase()) -> Abb aab 123
        ;
    }
}

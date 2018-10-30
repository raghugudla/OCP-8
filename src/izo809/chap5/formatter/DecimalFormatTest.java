package izo809.chap5.formatter;

import java.text.DecimalFormat;

public class DecimalFormatTest {

    public static void main(String[] args) {
        double d = 1234567.437;
        DecimalFormat one = new DecimalFormat("###,###,###.###");
        System.out.println(one.format(d)); // 1,234,567.437

        DecimalFormat two = new DecimalFormat("000,000,000.00000");
        System.out.println(two.format(d)); // 001,234,567.43700

        DecimalFormat three = new DecimalFormat("$###,###,###.##");
        System.out.println(three.format(d)); // $1,234,567.44

    }

}

package izo809.chap5.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumFormatEx {

    public static void main(String[] args) throws ParseException {
        double price = 48;
        NumberFormat sv = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"));
        System.out.println(sv.format(price));

        NumberFormat us = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        System.out.println(us.parse(sv.format("48,00")));
    }

}

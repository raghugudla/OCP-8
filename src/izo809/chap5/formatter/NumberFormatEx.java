package izo809.chap5.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatEx {
    public static void main(String[] args) throws ParseException {
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        String value = "444,33";
        System.out.println(nf.parse(value));
    }
}
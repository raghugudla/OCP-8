package izo809.chap5;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println("f0 = " + DateFormat.getDateInstance().format(date));
        System.out.println("f1 = " + DateFormat.getDateInstance(DateFormat.SHORT).format(date));
        System.out.println("f2 = " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
        System.out.println("f3 = " + DateFormat.getDateInstance(DateFormat.LONG).format(date));
        System.out.println("f4 = " + DateFormat.getDateInstance(DateFormat.FULL).format(date));

        System.out.println("---------------------");
        Locale locale = new Locale("sv");
        System.out.println("locale: " + locale);

        System.out.println("f1 = " + DateFormat.getDateInstance(DateFormat.SHORT, locale).format(date));
        System.out.println("f2 = " + DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(date));
        System.out.println("f3 = " + DateFormat.getDateInstance(DateFormat.LONG, locale).format(date));
        System.out.println("f4 = " + DateFormat.getDateInstance(DateFormat.FULL, locale).format(date));

        System.out.println("---------------------");

        System.out.println("f0 = " + DateFormat.getTimeInstance().format(date));
        System.out.println("f1 = " + DateFormat.getTimeInstance(DateFormat.SHORT).format(date));
        System.out.println("f2 = " + DateFormat.getTimeInstance(DateFormat.MEDIUM).format(date));
        System.out.println("f3 = " + DateFormat.getTimeInstance(DateFormat.LONG).format(date));
        System.out.println("f4 = " + DateFormat.getTimeInstance(DateFormat.FULL).format(date));

        System.out.println("---------------------");

        System.out.println("f0 = " + DateFormat.getInstance().format(date));

        System.out.println("---------------------");

        System.out.println("f0 = " + DateFormat.getDateTimeInstance().format(date));
        System.out.println("f1 = " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date));
        System.out.println("f2 = " + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(date));
        System.out.println("f3 = " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date));
        System.out.println("f4 = " + DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(date));

        System.out.println("---------------------");

        System.out.println("f1 = " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale).format(date));
        System.out.println("f2 = " + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale).format(date));
        System.out.println("f3 = " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale).format(date));
        System.out.println("f4 = " + DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale).format(date));

        System.out.println("---------------------");
    }

}

package izo809.chap5.rb;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class RbTest {

    public static void main(String[] args) {

        System.out.println("default locale: " + Locale.getDefault());

        Locale l2 = new Locale.Builder() // bad but legal
                .setRegion("us")
                .setLanguage("EN")
                .build();
        System.out.println(l2);

        Locale fr = new Locale("fr");
        Locale.setDefault(l2 /*new Locale("en", "US")*/);

        ResourceBundle rb = ResourceBundle.getBundle("Dolphins", fr);

        Set<String> keys = rb.keySet();
        keys.stream()
                .map(k -> k + " : " + rb.getString(k))
                .forEach(System.out::println);

        System.out.println("age: " + rb.getString("age"));
    }

}

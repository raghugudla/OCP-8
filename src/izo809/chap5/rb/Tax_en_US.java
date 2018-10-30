package izo809.chap5.rb;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tax_en_US extends ListResourceBundle {

    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle(
                "izo809.chap5.rb.Tax", Locale.US);

//        java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
//        System.out.println(rb.getString("tax"));
//      Key is always String in ListResourceBundle but value can be object

        System.out.println(rb.getObject("tax"));
        System.out.println(rb.getString("state"));

    }

    protected Object[][] getContents() {
        return new Object[][]{
                {"tax", 123},
                {"state", "IL"}
        };
    }

}

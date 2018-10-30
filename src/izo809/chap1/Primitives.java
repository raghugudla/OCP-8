package izo809.chap1;

public class Primitives {

    // byte, short, int, long default value is 0
    private static byte b1;
    private static short s1;
    private static int i1;
    private static long l1;

    // float, double default value is 0.0
    private static float f1;
    private static double d1;

    private static void meth1() {

        // must initialize primitives in methods
        byte b2 = b1;
        short s2 = b1;
        // down casting requires explicit type cast unlike upper casting
        int _123 = (int) l1; //_123 is literal
        long l2 = 0;

        System.out.println(b1 + " - " + b2);
        System.out.println(s1 + " - " + s2);
        System.out.println(i1 + " - " + _123);
        System.out.println(l1 + " - " + l2);

        int i3 = _123; //_123 is literal and it can be assigned to other int variables.
    }

    private static void meth2() {
        // must initialize primitives in methods
        float f2 = 123;
        float f3 = 0.123456789f; // f or F is mandatory with the decimal part
        double d2 = 0.123456789;
        double d3 = 0.123456789d; // d or D is optional

        System.out.println(f1 + " - " + f2 + " - " + f3 + " - " + ((double) f3));
        System.out.println(d1 + " - " + d2 + " - " + d3 + " - " + ((float) d3));
    }

    private static void meth3() {
        byte binary = 0b1_1;
        System.out.println("binary = " + binary);

        int octal = 0_11;
        System.out.println("octal = " + octal);

        int hexad = 0xFF;
        System.out.println("hexad = " + hexad);
    }

    public static void main(String... args) {
        meth3();
    }
}

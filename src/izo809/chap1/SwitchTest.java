package izo809.chap1;

public class SwitchTest {

    private static final String str = "str";

    public static void main(String[] args) {

        switch ("b") {

            default:
                System.out.println("DEFAULT....");
                //break;

            case "a":
                System.out.println("a");

            case str:
                System.out.println("b");

        }

        switch (0) {

            case 0_0:
                System.out.println("0_0");

                //case 0 :
                System.out.println("0");
        }

    }

}

package izo809.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * List<?>
 *     List<? extends Number>
 *         List<? extends Integer>
 *             List<Integer>
 *
 * List<?>
 *     List<? super Integer>
 *         List<? super Number>
 *             List<Number>
 * */
public class WildcardsEx {

    static void meth1(List<Number> numbers) {

    }

    static <N extends Number> void meth2(List<N> numbers) {
        numbers.forEach(o -> o.doubleValue());
        //numbers.add(1);
    }

    static void meth3(List<? extends Number> numbers) {
        numbers.forEach(o -> o.doubleValue());
        //numbers.add(1);
     }

    static void meth4(List<? super Number> numbers) {
        //numbers.forEach(o -> o.doubleValue);
        numbers.add(1);
        numbers.add(1.0);
    }

    static void printList(List<?> list) {
        list.forEach(Object::toString);
    }

    static void printObj(List<Object> list) {
        list.forEach(o -> o.toString());
    }

    static void test() {
        List<Map<String, String>> mapList = new ArrayList<>();
        mapList.add(new HashMap<>());
        Map<String, ?> map = mapList.get(0);
        //map.put("", "");
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        meth1(numbers);
        //meth1(doubles); // error

        meth2(numbers); // Number is also accepted.
        meth2(doubles);

        meth3(numbers);
        meth3(doubles);

        //printObj(numbers);
        //printObj(doubles);
        printList(numbers);
        printList(doubles);

        /* ***************************************** */
        List<Integer> integers = new ArrayList<>();
        List<? extends Integer> intList = integers;
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
        List<?> list = numList;
//        list.add(2.0); // error

        List<? super Number> superNumbers = numbers;
        List<? super Integer> superInts = superNumbers;
        list = superInts;

        superInts = integers;
        numList = numbers;

        List<? extends Number>  numList1 = new ArrayList<>();
        //numList1.add(new Integer(1));
    }
}

package izo809.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericsTypeEx<T> {
    private T t;

    GenericsTypeEx(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericsTypeEx<String> hi = new GenericsTypeEx<>("hi");
        GenericsTypeEx rawType = new GenericsTypeEx("there");

        rawType.inspect(10);
        rawType.inspect(10l);
        rawType.inspect(0.123456789F);
        rawType.inspect(0.123456789);

        //System.out.println("picked class: " + pick("A", new ArrayList<String>()).getClass());
        Serializable s = pick("A", new ArrayList<String>());
        System.out.println("s.getClass() = " + s.getClass());

        List<Integer> integers = Collections.emptyList();
        processStringList(Collections.emptyList());
    }

    @Override
    public String toString() {
        return t.toString();
    }

    private <N extends Number> void inspect(N n) {
        System.out.println("argument class: " + n.getClass());
    }

    static <T> T pick(T a1, T a2) { return a2; }

    static void processStringList(List<String> list) {

    }
}

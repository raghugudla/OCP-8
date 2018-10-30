package izo809.chap3;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ArrayDequeEx {

    public static void main(String[] args) {
        test2();
    }

    public static void test2() {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < 2; i++)
            queue.add(i); // can throw e

        queue.push(100);
        print(queue);
        queue.pop();

        for (int i = 0; i < 2; i++)
            System.out.println("peek: " + queue.peek());
        print(queue);

        for (int i = 2; i < 4; i++)
            queue.offer(i);
        print(queue);


        for (int i = 0; i < 6; i++)
            System.out.println("poll: " + queue.poll());
        print(queue);
    }

    private static void print(Queue<Integer> queue) {
        System.out.println("queue..." + queue);
        System.out.println("----");
    }

    public static void test1() {

        Map<Object, Object> map =
//				new TreeMap<>(); --> NPE 
                new HashMap<>();
        map.put(null, "Hello");
        System.out.println("map: " + map);
        map.put(null, "Hello Again");
        System.out.println("map: " + map);
    }

}

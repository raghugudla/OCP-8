package izo809.chap7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamEx {

    public static void main(String[] args) {
        ParallelStreamEx calculator = new ParallelStreamEx();
        // Define the data
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 4000; i++)
            data.add(i);
        // Process the data
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        double time = (System.currentTimeMillis() - start) / 1000.0;
        // Report results
        System.out.println("\nTasks completed in: " + time + " seconds");

        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }

    private int processRecord(int input) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // Handle interrupted exception
        }
        return input + 1;
    }

    private void processAllData(List<Integer> data) {
        // Tasks completed in: 62.204 seconds
        // data.stream().map(a -> processRecord(a)).count();

        // Tasks completed in: 15.657 seconds
        data.parallelStream().map(a -> processRecord(a)).count();
    }
}
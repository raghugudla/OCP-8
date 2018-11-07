package izo809.chap7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionEx extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;

    private RecursiveActionEx(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        RecursiveActionEx task = new RecursiveActionEx(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Object o = pool.invoke(task);
        System.out.println("o = " + o);
        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.stream(weights).forEach(
                d -> System.out.print(d.intValue() + " "));

    }

    @Override
    protected void compute() {
        System.out.println("start = " + start + ", end = " + end);
        if (end - start <= 3)
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
            }
        else {
            int middle = start + ((end - start) / 2);
            System.out.println("middle = " + middle);
            invokeAll(new RecursiveActionEx(weights, start, middle), new RecursiveActionEx(weights, middle, end));
        }
    }

}

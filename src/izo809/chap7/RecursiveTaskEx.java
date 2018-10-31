package izo809.chap7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskEx extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;

    private RecursiveTaskEx(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new RecursiveTaskEx(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("Sum: " + sum);
        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue() + " "));
    }

    @Override
    protected Double compute() {
        System.out.println("start = " + start + ", end = " + end);
        if (end - start <= 3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start + ((end - start) / 2);
            RecursiveTask<Double> otherTask = new RecursiveTaskEx(weights, start, middle);
            otherTask.fork();
            System.out.println("start = " + start + ",middle = " + middle + " fork");

            return new RecursiveTaskEx(weights, middle, end).compute()
                    + otherTask.join(); // Optional joining, just adding the sum in this UC
        }
    }
}
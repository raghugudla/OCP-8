package izo809.chap7;

import java.util.stream.DoubleStream;

public class RunnableEx implements Runnable {
    private double[] scores;

    public RunnableEx(double... scores) {
        this.scores = scores;
    }

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        new Thread(
                new RunnableEx(
                        1.0, 2.0, 3.0, 4.0
                )
        )
                .start();
        System.out.println("exiting main");
    }

    public void run() {
        System.out.println(" thread: " + Thread.currentThread().getName());
        System.out.println(" avg: " + DoubleStream.of(scores).average());
    }

}

package izo809.chap7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierEx {
    private int i = 0;

    public CyclicBarrierEx(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            CyclicBarrier c1 = new CyclicBarrier(4, () -> System.out.println("*** cleaning phase check!"));
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));
            for (int i = 1; i < 5; i++) {
                int j = i;
                service.submit(() -> new CyclicBarrierEx(j).performTask(c1, c2));
            }

        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private void removeAnimals() {
        System.out.println("Removing animals - " + i);
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen - " + i);
    }

    private void addAnimals() {
        System.out.println("Adding animals - " + i);
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        removeAnimals();
        try {
            c1.await();
            cleanPen();
            c1.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        addAnimals();
    }
}

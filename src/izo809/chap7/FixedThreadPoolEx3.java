package izo809.chap7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolEx3 {
    private int i = 0;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            FixedThreadPoolEx3 manager = new FixedThreadPoolEx3();
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private void removeAnimals(int i) {
        System.out.println("Removing animals - " + i);
    }

    private void cleanPen(int i) {
        System.out.println("Cleaning the pen - " + i);
    }

    private void addAnimals(int i) {
        System.out.println("Adding animals - " + i);
    }

    public void performTask() {
        ++i;
        removeAnimals(i);
        cleanPen(i);
        addAnimals(i);
    }
}

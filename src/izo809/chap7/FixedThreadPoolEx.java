package izo809.chap7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolEx {
    // private AtomicInteger sheepCount = new AtomicInteger();
    private int counter = 0;

    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(20);

            FixedThreadPoolEx manager = new FixedThreadPoolEx();

            Callable<String> c = () -> "";

            for (int i = 0; i < 100; i++)
                service.submit(() -> manager.incrementAndReport());

        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private void incrementAndReport() {
        synchronized (this) {
            System.out.println((++counter) + " ");
        }
    }

    private synchronized void decrementAndReport() {
        System.out.println((--counter) + " ");
    }

}

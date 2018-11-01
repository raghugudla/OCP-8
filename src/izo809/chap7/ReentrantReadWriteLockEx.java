package izo809.chap7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockEx {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // m1
            service = Executors.newFixedThreadPool(20);
            service.submit(() -> {
                readWriteLock.writeLock().lock(); // m2
                System.out.println("Got Write Lock!" + Thread.currentThread().getName());
                readWriteLock.writeLock().unlock(); // m2
            });
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    readWriteLock.readLock().lock(); // m3
                    System.out.println("Got Read Lock! " + Thread.currentThread().getName());
                    readWriteLock.readLock().unlock(); // m3
                });
            }
        } finally {
            if (service != null)
                service.shutdown();
        }
        System.out.print("Finished");
    }
}
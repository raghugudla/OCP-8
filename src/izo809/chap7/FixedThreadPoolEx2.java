package izo809.chap7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedThreadPoolEx2 {
    public static void goSwimming(Lock lock) {
        try {
            lock.lock(); // y1
            if (lock.tryLock()) { // y2
                System.out.println("Swim!");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(2);
            for (int i = 0; i < 2; i++)
                service.submit(() -> goSwimming(lock));
        } finally {
            if (service != null)
                service.shutdown();
        }
        System.out.print("Tasks Complete");
    }
}

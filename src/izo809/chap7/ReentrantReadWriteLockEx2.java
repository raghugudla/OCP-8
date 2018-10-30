package izo809.chap7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockEx2 {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private List<String> names = new ArrayList<>();

    public ReentrantReadWriteLockEx2() {
        names.add("John Smith");
        names.add("Sarah Smith");
        names.add("James Johnson");
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockEx2 manager = new ReentrantReadWriteLockEx2();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 10; i++) {
                final int employeeNumber = i;
                service.submit(() -> manager.readNames(employeeNumber));
                service.submit(() -> manager.addName("Grace Hopper - " + employeeNumber));
            }
        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private String readNames(int i) {
        Lock lock = readWriteLock.readLock();
        try {
            lock.lock();
            String s = names.get(i);
            System.out.println("Read Lock Obtained! " + i + " - " + s);
            return s;
        } finally {
            System.out.println("Read Lock Released!");
            lock.unlock();
        }
    }

    private void addName(String name) {
        Lock lock = readWriteLock.writeLock();
        try {
            lock.lock();
            System.out.println("Write Lock Obtained! " + name);
            Thread.sleep(1000);
            names.add(name);
        } catch (InterruptedException e) {
            // Handle thread interrupted exception
        } finally {
            System.out.println("Write Lock Released!");
            lock.unlock();
        }
    }
}

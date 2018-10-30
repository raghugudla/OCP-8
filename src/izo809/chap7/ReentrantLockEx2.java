package izo809.chap7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockEx2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        IntStream.iterate(1, i -> 1).limit(10).parallel().forEach(x -> { // w1
            lock.tryLock(); // w2
            System.out.println("Got Lock!");
            lock.unlock(); // w3
        });
        System.out.print("Finished");
    }
}

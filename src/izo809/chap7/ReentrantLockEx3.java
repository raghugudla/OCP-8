package izo809.chap7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx3 {

    private static int birdCount;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            //System.out.println(lock.tryLock()); -> Always returns true as the same thread already holds the lock.
            try {
                lock.lock();
                ++birdCount;
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
        new Thread(() -> {
            if (lock.tryLock()) {
                try {
                    System.out.println("Acquired");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unavailable");
            }
        }).start();

    }

}

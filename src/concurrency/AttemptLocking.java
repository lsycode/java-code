package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lsy on 2016/3/29.
 */

class a extends Thread {
    AttemptLocking al;

    a(AttemptLocking al) {
        this.al = al;
    }

    public void run() {
        System.out.println("-------");
        al.lock.lock();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.lock.unlock();
    }
}


public class AttemptLocking {
    public ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() throws InterruptedException {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        Thread x = new a(al);
        x.start();
//            {
//                setDaemon(true);
//            }
//
//            public void run() {
////                al.lock.lock();
//                System.out.println("acquired");
//            }
//        };
//        t.start();
        Thread.sleep(5);
        al.untimed();
        al.timed();
    }
}

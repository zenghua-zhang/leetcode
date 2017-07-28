package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动两个线程，顺序打印1 ~ 9， 一个线程打印1 2 3 7 8 9 ，一个线程打印 4 5 6
 * http://outofmemory.cn/java/java.util.concurrent/lock-reentrantlock-condition
 * @author ZZH
 *
 */
public class ReentrantThread {

    private static Boolean writing = true;

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition conForA = lock.newCondition();
        final Condition conForB = lock.newCondition();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA start write");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i);
                    }
                    conForB.signal();
                    writing = false;
                } finally {
                    lock.unlock();
                }

                try {
                    lock.lock();
                    conForA.await();
                    System.out.println("threadA start write");

                    for (int i = 7; i < 10; i++) {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    while (writing) {
                        conForB.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    lock.lock();
                    writing = true;
                    System.out.println("threadB start write");
                    for (int i = 4; i < 7; i++) {
                        System.out.println(i);
                    }
                    writing = false;
                    conForA.signal();
                } finally {
                    lock.unlock();
                }

            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }
}

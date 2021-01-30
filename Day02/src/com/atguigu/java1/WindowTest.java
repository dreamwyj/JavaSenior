package com.atguigu.java1;


import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * 用Lock锁
 * 1.创建ReentrantLock对象
 * 2.上锁，在try{}前一步，解锁，在finally中
 * @author yijin
 * @create 2021-01-28-19:15
 */
class MyThread implements Runnable {
    private int ticket = 100;
    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {

                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }


    }
}


public class WindowTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

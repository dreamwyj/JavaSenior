package com.atguigu.java1;

/**
 * wait()
 * notify()
 * 使用
 * 只能用于synchronized()
 * @author yijin
 * @create 2021-01-28-19:50
 */
class MyRun implements Runnable {
    private int num = 1;

    @Override
    public void run() {

        for (; num <= 100; ) {
            synchronized (this) {
                notify();//唤醒

                if (num <= 100) {

                    notifyAll();
                    System.out.println(Thread.currentThread().getName() + " :" + num);
                    num++;

                    try {
                        wait();//释放
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }

            }

        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread1 = new Thread(myRun);
        thread1.start();
        Thread thread2 = new Thread(myRun);
        thread2.start();
        Thread thread3 = new Thread(myRun);
        thread3.start();
        Thread thread4 = new Thread(myRun);
        thread4.start();

    }

}

package com.atguigu.java;

/**
 * 使用同步方法解决实现线程Runnable接口的线程安全问题
 *
 * @author yijin
 * @create 2021-01-27-20:47
 */
class MyThread implements Runnable{
    private int ticket = 50;
    @Override
    public void run() {
        while(ticket > 0) {

            show();

        }
    }
    public synchronized void show(){ //同步监视器就是this
            if(ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + ticket);
                ticket--;
            }
    }
}
public class WindowTest3 {
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

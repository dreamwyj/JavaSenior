package com.atguigu.java;

/**
 * 使用同步方法解决继承Thread()类的线程安全问题
 *
 * 1.非静态的同步方法，同步监视器是 this
 *   静态的同步方法，同步监视器是 当前类本身
 * 2.不需要声明显示的同步监视器
 *
 * @author yijin
 * @create 2021-01-27-21:04
 */
class MyThread2 extends Thread{
    private static int ticket = 100;



    @Override
    public void run() {
        while(ticket > 0) {
           show();


        }
    }
    private static synchronized void show(){ //静态方法随着类的加载而加载，只加载一次
        if(ticket > 0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + ticket);
            ticket--;

        }
    }
}


public class WindowTest4 {

    public static void main(String[] args) {
        MyThread2 mythread1 = new MyThread2();
        MyThread2 mythread2 = new MyThread2();
        MyThread2 mythread3 = new MyThread2();

        mythread1.start();
        mythread2.start();
        mythread3.start();
    }

}

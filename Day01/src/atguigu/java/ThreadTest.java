package com.atguigu.java;

/**
 * 多线程的创建
 * 方式一
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run() --->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 *
 *
 * @author yijin
 * @create 2021-01-26-17:03
 */

// 1.创建一个继承Thread类的子类
class MyThread extends Thread{
    // 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread() + ":" +i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {

        // 3.创建Thread类的子类对象
        MyThread myThread = new MyThread();
        // 4.通过对象调用start()方法：
        // 4.1 启动当前线程
        // 4.2 调用当前线程的run()方法
        myThread.start();

//        问题一：不能直接调用这个方法开启线程
//        myThread.run();
//        问题二：在启动一个线程，遍历100以内的偶数，不可以让已经start()的线程去执行，会报IllegalThreadStateException()
//        myThread.start();
//        我们需要创建一个线程对象
        MyThread myThread2 = new MyThread();
        myThread2.start();

        //如下操作仍然是在main线程中执行的
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1){
                System.out.println(Thread.currentThread() + ":" +i);
//                System.out.println("****main*****" + i);
            }
        }

    }

}

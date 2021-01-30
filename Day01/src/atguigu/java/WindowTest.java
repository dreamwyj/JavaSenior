package com.atguigu.java;

/**
 * 创建线程
 * 方式一：继承Thread类
 * 1.定义子类继承Thread()类
 * 2.子类重写run()方法
 * 3.创建Thread()的对象
 * 4.调用线程对象的start()方法
 *
 *  进程安全问题
 *
 * @author yijin
 * @create 2021-01-27-10:52
 */
class MyThread1 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " " +ticket);
                ticket--;
            }
            else{
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        MyThread1 myThread3 = new MyThread1();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

}

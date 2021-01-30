package com.atguigu.java;



/**
 * 创建线程
 * 方式一：继承Thread类
 * 1.定义子类继承Thread()类
 * 2.子类重写run()方法
 * 3.创建Thread()的对象
 * 4.调用线程对象的start()方法
 *
 *  进程安全问题:出现原因：当某个线程操作尚未完成时，其他进程参与进来操作，
 *  同步机制
 *
 *  方式一:同步代码块
 *  synchronized(同步监视器){
 *      // 需要被同步的代码
 *  }
 *  说明:1.操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据:多个线程共同操作的变量
 *      3.同步监视器:俗称：锁。任何一个类的对象都可以充当锁。
 *      要求:多个线程必须共用同一把锁
 *
 *      实现Runnable接口方式创建的线程中，可以考虑用this充当同步监视器
 *      通过继承Thread类创建线程的方式中，可以用 该文件名.class 充当锁
 *
 *  方式二:同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中
 *
 *
 * @author yijin
 * @create 2021-01-27-10:52
 */
class MyThread1 extends Thread{
    private static int ticket = 100;

    private static Object object = new Object();
    @Override
    public void run() {
        while(true) {
//           synchronized(this) this 代表三个对象，不能实现

            synchronized (WindowTest.class){
//            synchronized (object) {
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

package com.atguigu.java;

/**
 *
 * 创建线程方法二 实现Runnable接口
 * 1.定义子类，实现Runnable接口
 * 2.子类重写Runnable接口中的run方法
 * 3.通过Thread类含构造器创建线程对象
 * 4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中
 * 5.调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法
 *  公用一个变量，三个窗口公用一个对象
 *
 * 比较创建线程的两种方式:
 *
 *
 * @author yijin
 * @create 2021-01-27-13:42
 */

class MTread implements Runnable{
    private int ticket = 100;
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

public class WindowTest2 {
    public static void main(String[] args) {
        MTread mTread = new MTread();

        Thread thread1 = new Thread(mTread );
        thread1.setName("窗口1");
        thread1.start();
        Thread thread2 = new Thread(mTread );
        thread2.setName("窗口2");
        thread2.start();
        Thread thread3 = new Thread(mTread );
        thread3.setName("窗口3");
        thread3.start();


    }
}

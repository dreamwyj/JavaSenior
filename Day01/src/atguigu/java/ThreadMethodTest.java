package com.atguigu.java;


/**
 * 测试Thread类中的常用方法；
 * 1.start():启动当前线程，调用当前线程的run()方法
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前的执行权
 * 7.join()在线程A中调用线程B的join，此时线程A就进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 * 8.sleep(long millitime):让当前线程"睡眠"指定的millitime毫秒。
 * 在指定的millitime毫秒时间内，当前线程是阻塞的。
 * 9.islive():判断当前优先级是否存活
 *
 * 线程的优先级
 * 线程的优先级等级
 *  > Max_PRIORITY:10
 *  > Min_PRIORITY:1
 *  > NORM_PRIORITY:5
 * 方法:
 *  > getPriority()
 *  > setPriority(int newPriority)
 *
 *
 * @author yijin
 * @create 2021-01-27-08:59
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if (i  == 20){
//                yield();
////                h1.join();
//
//            }

        }
    }

    public HelloThread(String name) {
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");
//        h1.setName("线程一");
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            // option + enter
            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(h1.isAlive());

        }

    }
}

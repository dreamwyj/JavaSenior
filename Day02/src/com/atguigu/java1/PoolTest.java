package com.atguigu.java1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 *
 * @author yijin
 * @create 2021-01-29-17:37
 *
 */
class MyRunnable1 implements Runnable{
    private int num = 0;
    @Override
    public void run() {
        for (;num <= 100;num++){
            System.out.println(Thread.currentThread().getName() + ":" + num);
        }
    }
}

class MyRunnable2 implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        for (;num <= 100;num++){
            if(num % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + num);
            }
        }
    }
}

public class PoolTest {
    public static void main(String[] args) {
        // 1.提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor =  (ThreadPoolExecutor)executorService;

        // 设置线程池的属性
        System.out.println(executorService.getClass());
        threadPoolExecutor.setCorePoolSize(15);

        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口的对象
        MyRunnable1 myRunnable1 = new MyRunnable1();
        threadPoolExecutor.submit(myRunnable1);

        MyRunnable2 myRunnable2 = new MyRunnable2();
        threadPoolExecutor.submit(myRunnable2);

        //3.关闭线程池
        threadPoolExecutor.shutdown();


    }
}

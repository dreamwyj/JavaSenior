package com.atguigu.java1;

/**
 * 出现死锁
 * @author yijin
 * @create 2021-01-28-19:02
 */
public class DeadLockTest {
    public static void main(String[] args) {
        final StringBuffer s1 = new StringBuffer();
        final StringBuffer s2 = new StringBuffer();

        //用继承Thread类的方式创建接口
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("A");
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s2.append("B");
                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }

            }
        }.start();
        //实现Runnable接口的方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s2.append("C");
                    synchronized (s1){
                        s1.append("D");
                        System.out.println(s2);
                        System.out.println(s1);
                    }
                }
            }
        }).start();

    }
}

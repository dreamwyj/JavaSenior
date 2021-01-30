package com.atguigu.java;

/**方法二：
 *  1.实现Runnable接口
 *  2.创建实现类的对象
 *  3.通过Thread类含参构造器创建线程对象
 *  4.通过Thread类的对象调用start()
 *      > 创建线程
 *      > 调用当前线程的类方法
 * @author yijin
 * @create 2021-01-27-11:24
 */
class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        MThread myThread = new MThread();
        Thread thread = new Thread(myThread);
        thread.start();

    }
}

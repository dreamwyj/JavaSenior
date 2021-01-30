package com.atguigu.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口
 * 1.创建一个实现Callable的实现类
 * 2.实现call方法，将此线程需要执行的操作声明在call()中
 * 3.创建Callable接口的实现类
 * 4.将此Callable接口实现类的对象作为值传递到FutureTask构造器中，创建FutureTask对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
 * 6.获取Callable中call方法的返回值
 * // get()返回值即为FutureTask构造器参数Callable实现类重写的call()返回值
 * @author yijin
 * @create 2021-01-29-16:22
 */
//1.创建一个实现Callable的实现类
class MyCall implements Callable{
    // 2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
       for (int i = 1 ;i <= 100; i ++){
           if (i % 2 == 0){
               sum += i;
               System.out.println(Thread.currentThread().getName() + " :" + i);
           }
       }
        return sum;
    }
}

public class CallableTest {

    public static void main(String[] args) {
        //3.创建一个Callable实现类的对象
        MyCall myCall = new MyCall();
        //4.将Callable实践类的对象作为FutureTask类的形参创建FutureTask类的对象
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(myCall);
        //5.把FutureTask对象作为构造器参数，创建一个Thread()对象
        Thread thread = new Thread(integerFutureTask);
        //6.调用start()方法
        thread.start();
        try {
            Integer sum = integerFutureTask.get();
            System.out.println("总和为：" + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//    FutureTask

}

package com.atguigu.java1;


import static java.lang.Thread.*;

/**
 * @author yijin
 * @create 2021-01-29-19:29
 */
class Clerk{
    // 售货员

    private static int product = 0;

    public static int getProduct() {
        return product;
    }

    public synchronized  void addProduction() {

            if (product < 20) {
                notifyAll();

                product++;
                System.out.println(currentThread().getName() + " 生产一个产品,产品还剩:" + product);


            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    public synchronized void getProduction() {

            if (product > 0) {
                notifyAll();
                product--;
                System.out.println(currentThread().getName() + " 获得一个产品,产品还剩:" + product);
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
class Customer implements Runnable{
    // 客户
    Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.getProduction();
        }
    }
}
class Factory implements Runnable {
    Clerk clerk;

    public Factory(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        while (true) {
            try {
                sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProduction();

        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Factory factory = new Factory(clerk);

        Thread thread = new Thread(factory);
        thread.start();

        Customer customer = new Customer(clerk);
        Thread thread1 = new Thread(customer);
        thread1.start();


    }
}

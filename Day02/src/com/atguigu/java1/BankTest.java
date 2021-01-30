package com.atguigu.java1;

/** 懒汉式
 * @author yijin
 * @create 2021-01-27-22:19
 */
class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    private static Bank getInstance() {
////        方式一: 效率稍差
//        synchronized (Bank.class){
//            if(instance == null){
//                instance = new Bank();
//            }
//        }
//        方式二: 效率稍高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {

}

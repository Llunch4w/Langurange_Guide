/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 8:17
 * @ Description 礼让线程
 */
package myjava.juc;

public class YieldTest implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "结束执行");
    }

    public static void main(String[] args){
        new Thread(new YieldTest(),"a").start();
        new Thread(new YieldTest(),"b").start();
    }
    
}

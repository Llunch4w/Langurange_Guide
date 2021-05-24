/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 16:40
 * @ Description 通过同步锁实现线程安全的模拟购票
 */
package myjava.juc;

import java.util.concurrent.locks.ReentrantLock;

public class BuyTicketsLockTest {
    public static void main(String[] args){
        LockBuyer buyer = new LockBuyer();
        new Thread(buyer,"小明").start();
        new Thread(buyer,"小黑").start();
        new Thread(buyer,"小红").start();
    }
}

class LockBuyer implements Runnable{
    private static int ticket = 10;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run(){
        while(ticket > 0){
            buy();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void buy(){
        try{
            lock.lock();
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "买到了第" + ticket + "张票");
                ticket--;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }        
    }
}

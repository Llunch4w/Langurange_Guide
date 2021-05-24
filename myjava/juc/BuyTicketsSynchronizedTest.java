/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 16:27
 * @ Description 通过同步方法实现线程安全的模拟购票
 */
package myjava.juc;

public class BuyTicketsSynchronizedTest {
    public static void main(String[] args){
        SynchronizedBuyer buyer = new SynchronizedBuyer();
        new Thread(buyer,"小明").start();
        new Thread(buyer,"小黑").start();
        new Thread(buyer,"小红").start();
    }
}

class SynchronizedBuyer implements Runnable{
    private static int ticket = 10;

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

    public synchronized void buy(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "买到了第" + ticket + "张票");
            ticket--;
        }
    }
}

/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 16:17
 * @ Description 模拟线程不安全的购票
 */
package myjava.juc;

public class BuyTicketsNoSafeTest {
    public static void main(String[] args){
        Buyer buyer = new Buyer();
        new Thread(buyer, "小明").start();
        new Thread(buyer, "小王").start();
        new Thread(buyer, "小红").start();
    }
}

class Buyer implements Runnable{
    private static int ticket = 10;
    @Override
    public void run(){
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "买到了第" + ticket + "张票");
            ticket--;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

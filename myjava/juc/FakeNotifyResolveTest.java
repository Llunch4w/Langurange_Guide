/**
 * @ Author LuckyQ
 * @ Date   2021-05-25 10:10
 * @ Description 生产者消费者模式中的虚假唤醒问题解决
 */
package myjava.juc;

public class FakeNotifyResolveTest {
    public static void main(String[] args){
        WhileData data = new WhileData();

        for(int k = 0; k < 2; k++){
            new Thread(()->{
                for(int i = 0; i < 20; i++){
                    data.increase();
                }
            },"IncreaseThread").start();
    
            new Thread(()->{
                for(int i = 0; i < 20; i++){
                    data.decrease();
                }
            },"DecreaseThread").start();
        }
    }
}

class WhileData{
    private int num = 0;

    public synchronized void increase(){
        while(num != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "执行加1操作，num = " + num);
        this.notifyAll();
    }

    public synchronized void decrease(){
        while(num == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "执行减1操作，num = " + num);
        this.notifyAll();
    }
}
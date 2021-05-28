/**
 * @ Author LuckyQ
 * @ Date   2021-05-25 9:56
 * @ Description 生产者消费者模式中的虚假唤醒问题
 */
package myjava.juc;

public class FakeNotifyTest {
    public static void main(String[] args){
        Data data = new Data();

        for(int k = 1; k <= 2; k++){
            new Thread(()->{
                for(int i = 0; i < 20; i++){
                    data.increase();
                }
            },"IncreaseThread" + k).start();
    
            new Thread(()->{
                for(int i = 0; i < 20; i++){
                    data.decrease();
                }
            },"DecreaseThread" + k).start();
        }
    }
}


class Data{
    private int num = 0;

    public synchronized void increase(){
        if(num != 0){
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
        if(num == 0){
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
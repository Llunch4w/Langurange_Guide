/**
 * @ Author LuckyQ
 * @ Date   2021-05-25 6:43
 * @ Description 通过管程实现生产者消费者模式
 */
package myjava.juc;

public class ProducerConsumerTest {
    public static void main(String[] args){
        SynContainer container = new SynContainer();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);
        
        producer.start();
        consumer.start();

    }
}

class Producer extends Thread{
    private SynContainer container;

    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("生产了第" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread{
    private SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            Chicken chicken = container.pop();
            System.out.println("消费了第" + chicken.getNo() + "只鸡");
        }
    }
}

// 产品
class Chicken{
    private int no;

    public Chicken(int no){
        this.no = no;
    }

    public int getNo(){
        return no;
    }
}

// 缓冲区
class SynContainer{
    private Chicken[] chickens = new Chicken[10];
    private int count = 0;

    // producer produce a product and push into container
    public synchronized void push(Chicken chicken){
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    // consumer consume a product
    public synchronized Chicken pop(){
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}

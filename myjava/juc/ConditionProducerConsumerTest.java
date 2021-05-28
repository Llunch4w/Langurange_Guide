/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 19:41
 * @ Description 通过Condition实现生产者消费者模式
 */
package myjava.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionProducerConsumerTest {
    public static void main(String[] args){
        ConditionContainer container = new ConditionContainer();

        new Thread(()->{
            for(int i = 0; i < 20; i++){
                container.push(new ConditionChicken(i));
            }
        },"Producer").start();

        new Thread(()->{
            for(int i = 0; i < 20; i++){
                container.pop();
            }
        },"Consumer").start();
    }
}

// 产品
class ConditionChicken{
    private int no;

    public ConditionChicken(int no){
        this.no = no;
    }

    public int getNo(){
        return no;
    }
}

class ConditionContainer{
    private ConditionChicken[] chickens = new ConditionChicken[5];
    int index = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void push(ConditionChicken chicken){
        lock.lock();
        try{
            while(index == chickens.length){
                condition.await();
            }
            chickens[index] = chicken;
            index++;
            System.out.println(Thread.currentThread().getName() + "添加" + chicken.getNo() + "号小鸡");
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public ConditionChicken pop(){
        ConditionChicken chicken = null;
        lock.lock();
        try{
            while(index == 0){
                condition.await();
            }
            index--;
            chicken = chickens[index];
            System.out.println(Thread.currentThread().getName() + "拿走" + chicken.getNo() + "号小鸡");
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        
        return chicken;
    }
}
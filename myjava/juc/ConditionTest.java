/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 19:48
 * @ Description 通过Condition实现精准控制，A执行完调用B，B执行完调用C，C执行完调用A
 */
package myjava.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args){
        ConditionData data = new ConditionData();

        new Thread(()->{
            for(int i = 0; i < 10; i++){
                data.printA();
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0; i < 10; i++){
                data.printB();
            }
        },"B").start();

        new Thread(()->{
            for(int i = 0; i < 10; i++){
                data.printC();
            }
        },"C").start();
    }
}

class ConditionData{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA(){
        lock.lock();
        try{
            while(num != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            num = 2;
            condition2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try{
            while(num != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBBB");
            num = 3;
            condition3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try{
            while(num != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCCC");
            num = 1;
            condition1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 20:38
 * @ Description 七锁问题3 -- 1个同步方法，2个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock3Test {
    public static void main(String[] args){
        new Thread(()->{new Obj3().func1();}, "Thread-A").start();
        new Thread(()->{new Obj3().func1();}, "Thread-B").start();
    }
}

class Obj3{
    public synchronized void func1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":func1");
    }
}
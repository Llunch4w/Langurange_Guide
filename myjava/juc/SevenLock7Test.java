/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 21:07
 * @ Description 七锁问题6 -- 1个静态同步方法，1个普通同步方法，2个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock7Test {
    public static void main(String[] args){
        new Thread(()->{new Obj7().func1();}).start();
        new Thread(()->{new Obj7().func2();}).start();
    }
}

class Obj7{
    public static synchronized void func1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("func1");
    }

    public void func2(){
        System.out.println("func2");
    }
}
/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 21:03
 * @ Description 七锁问题6 -- 1个静态同步方法，1个普通同步方法，1个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock6Test {
    public static void main(String[] args){
        Obj6 obj = new Obj6();

        new Thread(()->{obj.func1();}).start();
        new Thread(()->{obj.func2();}).start();
    }
}

class Obj6{
    public static synchronized void func1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("func1");
    }

    public synchronized void func2(){
        System.out.println("func2");
    }
}

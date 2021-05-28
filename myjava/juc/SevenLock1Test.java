/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 20:22
 * @ Description 七锁问题1 -- 2个同步方法，1个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock1Test {
    public static void main(String[] args){
        Obj1 obj = new Obj1();

        new Thread(()->{obj.func1();}).start();
        new Thread(()->{obj.func2();}).start();
    }
}

class Obj1{
    public synchronized void func1(){
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

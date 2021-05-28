/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 20:32
 * @ Description 七锁问题2 -- 1个同步方法，1个普通方法，1个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock2Test {
    public static void main(String[] args){
        Obj2 obj = new Obj2();

        new Thread(()->{obj.func1();}).start();
        new Thread(()->{obj.func2();}).start();
    }
}

class Obj2{
    public synchronized void func1(){
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
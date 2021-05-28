/**
 * @ Author LuckyQ
 * @ Date   2021-05-28 20:44
 * @ Description 七锁问题4 -- 2个静态同步方法，1个对象
 */
package myjava.juc;
import java.util.concurrent.TimeUnit;

public class SevenLock4Test {
    public static void main(String[] args){
        Obj4 obj = new Obj4();

        new Thread(()->{obj.func1();}).start();
        new Thread(()->{obj.func2();}).start();
    }
}

class Obj4{
    public static synchronized void func1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("func1");
    }

    public static synchronized void func2(){
        System.out.println("func2");
    }
}

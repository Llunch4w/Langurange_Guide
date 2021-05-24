/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 9:01
 * @ Description 线程优先级
 */
package myjava.juc;

public class PriorityTest implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "开始执行");
        System.out.println(Thread.currentThread().getName() + "执行结束");
    }
    
    public static void main(String[] args){
        PriorityTest test = new PriorityTest();

        Thread thread1 = new Thread(test, "level-1");
        Thread thread2 = new Thread(test, "level-5");
        Thread thread3 = new Thread(test, "level-10");
        Thread thread4 = new Thread(test, "level-3");

        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(5);
        thread2.start();

        thread3.setPriority(10);
        thread3.start();

        thread4.setPriority(3);
        thread4.start();

    }
}

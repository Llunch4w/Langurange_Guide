/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 20:46
 * @ Description 通过同步锁安全地向集合中添加元素
 */
package myjava.juc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ListAddLockTest {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        
        for(int i = 0;i < 1000; i++){
            new Thread(()->{
                try{
                    lock.lock();
                    list.add(Thread.currentThread().getName());
                }finally{
                    lock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list.size() = " + list.size());
    }
}

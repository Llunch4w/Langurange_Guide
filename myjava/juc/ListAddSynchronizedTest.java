/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 20:43
 * @ Description 通过同步块安全地向集合中添加元素
 */
package myjava.juc;
import java.util.ArrayList;
import java.util.List;

public class ListAddSynchronizedTest {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args){
        for(int i = 0;i < 1000; i++){
            new Thread(()->{
                synchronized(list){
                    list.add(Thread.currentThread().getName());
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

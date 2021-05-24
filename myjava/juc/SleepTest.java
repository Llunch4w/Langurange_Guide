/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 8:03
 * @ Description 基于sleep函数模拟倒计时
 */
package myjava.juc;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest implements Runnable{
    @Override
    public void run(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        int last = 10;
        while(last >= 0){
            System.out.println(last + "-->" + sdf.format(date));
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            date = new Date();
            last--;
        }
    }

    public static void main(String[] args){
        new Thread(new SleepTest()).start();
    }
    
}

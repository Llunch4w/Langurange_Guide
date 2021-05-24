/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 8:10
 * @ Description 通过标志位停止线程
 */
package myjava.juc;

public class StopTest implements Runnable{
    private boolean flag = true;

    @Override
    public void run(){
        int index = 0;
        while(flag){
            System.out.println("run : " + index);
            index++;
        }
    }   

    public void stop(){
        flag = false;
    }
    
    public static void main(String[] args){
        StopTest test = new StopTest();
        new Thread(test).start();

        for(int i = 0; i < 300; i++){
            if(i == 200){
                test.stop();
            }
            System.out.println("main : " + i);
        }
    }
}

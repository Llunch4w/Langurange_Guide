/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 8:21
 * @ Description 插队线程
 */
package myjava.juc;

public class JoinTest implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 500; i++){
            System.out.println("run : " + i);
        }
    }

    public static void main(String[] args){
        JoinTest test = new JoinTest();
        Thread thread = new Thread(test);
        thread.start();

        for(int i = 0; i < 300; i++){
            System.out.println("main : " + i);
            if(i == 100){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}

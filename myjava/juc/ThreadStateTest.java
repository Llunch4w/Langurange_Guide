/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 8:39
 * @ Description 线程状态
 */
package myjava.juc;

public class ThreadStateTest implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            System.out.println(Thread.currentThread().getName() + " : " 
                + Thread.currentThread().getState().toString());
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Thread threadA = new Thread(new ThreadStateTest(),"A");
        Thread threadB = new Thread(new ThreadStateTest(),"B");

        System.out.println("A State : " + threadA.getState().toString());
        System.out.println("B State : " + threadB.getState().toString());

        threadA.start();
        threadB.start();

        for(int i = 0; i < 15; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Main : " + i);
            System.out.println("Main : " + Thread.currentThread().getState().toString());
            System.out.println("A State : " + threadA.getState().toString());
            System.out.println("B State : " + threadB.getState().toString());
        }

        System.out.println("A State : " + threadA.getState().toString());
        System.out.println("B State : " + threadB.getState().toString());

    }
    
}

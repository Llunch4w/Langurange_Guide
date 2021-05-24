/**
 * @ Author LuckyQ
 * @ Date   2021-05-23 15:48
 * @ Description 模拟龟兔赛跑，龟兔是两个线程
 */
package myjava.juc;

public class RaceTest implements Runnable{
    private static final int ALL_STEP = 100;
    private int alreadyStep = 0;
    private static String winner = "unknown";
    private static boolean gameOver = false;

    @Override
    public void run(){
        for(int i = 0; !gameOver && i < ALL_STEP; i++){
            alreadyStep++;
            
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "走了" + alreadyStep + "步");
            if(alreadyStep == ALL_STEP){
                winner = threadName;
                gameOver = true;
            }
            if(threadName.equals("兔子") && alreadyStep%20 == 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        new Thread(new RaceTest(),"兔子").start();
        new Thread(new RaceTest(),"乌龟").start();

        // Wait some time that kid thread can be finished
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            System.out.println(winner + "获胜");
        }
    }
}

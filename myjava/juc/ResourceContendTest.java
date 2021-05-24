/**
 * @ Author LuckyQ
 * @ Date   2021-05-23 15:09
 * @ Description 多线程下的资源争夺场景模拟，可以看到多个线程拿到同一个资源的情况
 */

package myjava.juc;

public class ResourceContendTest implements Runnable{
    private int resources = 10;

    public static void main(String[] args){
        int N = 5;
        for(int i = 0; i < N; i++){
            new Thread(new ResourceContendTest(),"Thread-" + i).start();
        }
    }

    @Override
    public void run() {
        while(true){
            if(resources <= 0){
                break;
            }
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + resources-- + "个资源");
        }
    }
}

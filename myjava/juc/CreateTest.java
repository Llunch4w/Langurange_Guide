/**
 * @ Author LuckyQ
 * @ Date   2021-05-23 14:55
 * @ Description 创建线程的三种方式：继承Thread、实现Runnable、实现Callable
 */

package myjava.juc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateTest { 
    public static void main(String[] args){
        new ThreadKid().start();
        new Thread(new RunnableRealizer()).start();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Future<int[]>> futureList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Future<int[]> fu = executorService.submit(new CallabelRealizer());
            futureList.add(fu);
        }

        try {
            for(Future<int[]> future: futureList){
                int[] result = future.get();
                for(int i = 0; i < result.length; i++){
                    System.out.print(result[i] + "\t");
                }
                System.out.println();
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            executorService.shutdownNow();
        }
    }
}

class ThreadKid extends Thread{
    @Override
    public void run(){
        System.out.println("线程继承者" + this.getName() + "运行...");
    }
}

class RunnableRealizer implements Runnable{
    @Override
    public void run(){
        System.out.println("Runnable接口实现者运行...");
    }
}

class CallabelRealizer implements Callable<int[]>{
    @Override
    public int[] call() throws Exception{
        System.out.println("Callabel接口实现者运行...");
        try{
            Thread.sleep(200);
        }catch(Exception e){
            e.printStackTrace();
        }
        int[] res = new int[10];
        for(int i = 0; i < 10; i++){
            res[i] = i * 2;
        }
        return res;
    }
}

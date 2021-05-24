/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 9:23
 * @ Description 模拟上帝（守护进程）和人（用户进程）
 */
package myjava.juc;

public class DaemonTest{
    public static void main(String[] args){
        Thread godThread = new Thread(new God());
        godThread.setDaemon(true);

        Thread peopleThread = new Thread(new People());
        peopleThread.setDaemon(false); // false is default

        godThread.start();
        peopleThread.start();
    }
    
}

class God implements Runnable{
    @Override
    public void run(){
        while(true){
            System.out.println("上帝守护着你");
        }
    }
}

class People implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("人已经" + i + "岁了");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("人生结束了...");
    }
}
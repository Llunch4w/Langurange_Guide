/**
 * @ Author LuckyQ
 * @ Date   2021-05-25 7:06
 * @ Description 通过信号量实现生产者消费者模式
 */
package myjava.juc;

public class PlayerWatcherTest {
    public static void main(String[] args){
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);
        
        player.start();
        watcher.start();
    }
}

// 生产者--演员
class Player extends Thread{
    private TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run(){
        for(int i = 0; i < 20; i++){
            if(i % 2 == 0){
                this.tv.play("快乐大本营");
            }
            else{
                this.tv.play("抖音");
            }
        }
    }
}

// 消费者--观众
class Watcher extends Thread{
    private TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 20; i++){
            this.tv.watch();
        }
    }
}

// 产品--节目
class TV{
    /**
     * 演员表演 观众等待 T
     * 观众观看 演员等待 F
     */
    String show;
    boolean flag = true;

    // 表演
    public synchronized void play(String show){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了 : " + show);
        // 通知观众观看
        this.notifyAll();
        this.show = show;
        flag = !flag;
    }

    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了 : " + this.show);
        // 通知演员表演
        this.notifyAll();
        flag = !flag;
    }
}

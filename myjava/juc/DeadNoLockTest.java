/**
 * @ Author LuckyQ
 * @ Date   2021-05-25 6:23
 * @ Description 模拟女孩化妆场景下，通过破坏[请求和保持]条件来避免死锁
 */
package myjava.juc;

public class DeadNoLockTest {
    public static void main(String[] args){
        Mirror mirror = new Mirror();
        EyeBrush eyeBrush = new EyeBrush();

        new Thread(new NoLockMakeUp(mirror, eyeBrush, "mirror"), "小红").start();
        new Thread(new NoLockMakeUp(mirror, eyeBrush, "eyeBrush"), "小花").start();
    }
}

class NoLockMakeUp implements Runnable{
    private Mirror mirror = new Mirror();
    private EyeBrush eyeBrush = new EyeBrush();
    private String choice; // 优先使用镜子还是眼刷

    public NoLockMakeUp(Mirror mirror, EyeBrush eyeBrush, String choice){
        this.mirror = mirror;
        this.eyeBrush = eyeBrush;
        this.choice = choice;
    }

    @Override
    public void run(){
        if(choice.equals("mirror")){
            synchronized(mirror){
                System.out.println(Thread.currentThread().getName() + "获得了镜子的使用权");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "想获得眼刷的使用权");
            synchronized(eyeBrush){
                System.out.println(Thread.currentThread().getName() + "获得了眼刷的使用权");
            }
        }
        else{
            synchronized(eyeBrush){
                System.out.println(Thread.currentThread().getName() + "获得了眼刷的使用权");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "想获得镜子的使用权");
            synchronized(mirror){
                System.out.println(Thread.currentThread().getName() + "获得了镜子的使用权");
            }
        }
    }

}
/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 20:17
 * @ Description 通过同步锁实现线程安全的银行取钱模拟
 */
package myjava.juc;

import java.util.concurrent.locks.ReentrantLock;

public class BankLockTest {
    public static void main(String[] args){
        Account account = new Account(1000, "基金");

        LockBank people1 = new LockBank(account, 50, "小明");
        LockBank people2 = new LockBank(account, 100, "小红");

        new Thread(people1).start();
        new Thread(people2).start();
    }
}

class LockBank implements Runnable{
    Account account; // 账户
    int drawMoney;   // 本次操作取出的钱
    int nowMoney;    // 操作后用户手里的钱
    String name;     // 执行操作的用户名

    static ReentrantLock lock = new ReentrantLock();

    public LockBank(Account account, int drawMoney, String name){
        this.account = account;
        this.drawMoney = drawMoney;
        this.name = name;
    }

    @Override
    public void run(){
        try{
            lock.lock();
            if(account.money - drawMoney < 0){
                System.out.println(name + "取钱时账户里钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawMoney;
            nowMoney += drawMoney;
            System.out.println(account.name + "余额为:" + account.money);
            System.out.println(name + "取钱成功，现在手里的钱为：" + nowMoney);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
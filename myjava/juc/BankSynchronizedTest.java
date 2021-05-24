/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 20:03
 * @ Description 通过同步块实现线程安全的银行取钱模拟
 */
package myjava.juc;

public class BankSynchronizedTest {
    public static void main(String[] args){
        Account account = new Account(100, "基金");

        SynchronizedBank people1 = new SynchronizedBank(account, 50, "小明");
        SynchronizedBank people2 = new SynchronizedBank(account, 100, "小红");

        new Thread(people1).start();
        new Thread(people2).start();
    }
}

class SynchronizedBank implements Runnable{
    Account account; // 账户
    int drawMoney;   // 本次操作取出的钱
    int nowMoney;    // 操作后用户手里的钱
    String name;     // 执行操作的用户名

    public SynchronizedBank(Account account, int drawMoney, String name){
        this.account = account;
        this.drawMoney = drawMoney;
        this.name = name;
    }

    @Override
    public void run(){
        synchronized(account){
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
        }
    }
}

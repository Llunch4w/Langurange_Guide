/**
 * @ Author LuckyQ
 * @ Date   2021-05-24 16:48
 * @ Description 线程不安全的银行取钱模拟
 */
package myjava.juc;

public class BankNoSafeTest {
    public static void  main(String[] args){
        Account account = new Account(100, "基金");

        Drawing people1 = new Drawing(account, 50, "小明");
        Drawing people2 = new Drawing(account, 100, "小红");

        new Thread(people1).start();
        new Thread(people2).start();
    }
}

class Account{
    int money;
    String name;
    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

class Drawing implements Runnable{
    Account account; // 账户
    int drawMoney;   // 本次操作取出的钱
    int nowMoney;    // 操作后用户手里的钱
    String name;     // 执行操作的用户名

    public Drawing(Account account, int drawMoney, String name){
        this.account = account;
        this.drawMoney = drawMoney;
        this.name = name;
    }

    @Override
    public void run(){
        if(account.money - drawMoney < 0){
            System.out.println(name + "钱不够，取不了");
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
        System.out.println(name + "手里的钱为：" + nowMoney);
    }
}


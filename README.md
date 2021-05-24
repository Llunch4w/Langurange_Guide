# Langurange_Guide

从大一到现在即将大四毕业，也学了不少编程语言，包括：C/C++、Java、Python、C#、R。语法规则都是大同小异，但只有最近还在使用的Java和Python用起来比较熟。其他语言要用的话需要先查资料复习一遍。

所以，不如自己创建一个复习仓库。It's here !

# 已添加名录

## 一、Java

|主题|标签|代码|
|---|---|---|
|多线程|多线程创建|[CreateTest.java](./myjava/juc/CreateTest.java)|
|多线程|模拟多线程中资源争夺导致的紊乱|[ResourceContendTest.java](./myjava/juc/ResourceContendTest.java)|
|多线程|模拟龟兔赛跑|[RaceTest.java](./myjava/juc/RaceTest.java)|
|Java8新特性|Lambda表达式|[LambdaTest.java](./myjava/java8/LambdaTest.java)|
|多线程|基于sleep模拟倒计时|[SleepTest.java](./myjava/juc/SleepTest.java)|
|多线程|通过标志位停止线程|[StopTest.java](./myjava/juc/StopTest.java)|
|多线程|礼让线程|[YieldTest.java](./myjava/juc/YieldTest.java)|
|多线程|插队线程|[JoinTest.java](./myjava/juc/JoinTest.java)|
|多线程|线程状态|[ThreadStateTest.java](./myjava/juc/ThreadStateTest.java)|
|多线程|线程优先级|[PriorityTest.java](./myjava/juc/PriorityTest.java)|
|多线程|通过守护进程模拟上帝和人的关系|[DaemonTest.java](./myjava/juc/DaemonTest.java)|
|多线程|线程不安全场景1--模拟购票|[BuyTicketsNoSafeTest.java](./myjava/juc/BuyTicketsNoSafeTest.java)|
|多线程|线程安全的模拟购票--通过同步方法实现|[BuyTicketsSynchronizedTest.java](./myjava/juc/BuyTicketsSynchronizedTest.java)|
|多线程|线程安全的模拟购票--通过同步锁实现|[BuyTicketsLockTest.java](./myjava/juc/BuyTicketsLockTest.java)|
|多线程|线程不安全场景2--模拟从银行取钱|[BankNoSafeTest.java](./myjava/juc/BankNoSafeTest.java)|
|多线程|线程安全的模拟银行取钱---通过同步块实现|[BankSynchronizedTest.java](./myjava/juc/BankSynchronizedTest.java)|
|多线程|线程安全的模拟银行取钱---通过同步锁实现|[BankLockTest.java](./myjava/juc/BankLockTest.java)|
|多线程|线程不安全场景3--向集合中添加元素|[ListAddNoSafeTest.java](./myjava/juc/ListAddNoSafeTest.java)|
|多线程|线程安全的集合元素添加---通过同步块实现|[ListAddSynchronizedTest.java](./myjava/juc/ListAddSynchronizedTest.java)|
|多线程|线程安全的集合元素添加---通过同步锁实现|[ListAddLockTest.java](./myjava/juc/ListAddLockTest.java)|
|多线程|模拟女孩化妆场景下的死锁|[DeadLokTest.java](./myjava/juc/DeadLokTest.java)|
|多线程|模拟女孩化妆场景下的死锁解决|[DeadNoLockTest.java](./myjava/juc/DeadNoLockTest.java)|
|多线程|基于管程的生产者消费者模拟|[ProducerConsumerTest.java](./myjava/juc/ProducerConsumerTest.java)|
|多线程|基于信号量的生产者消费者模拟|[PlayerWatcherTest.java](./myjava/juc/PlayerWatcherTest.java)|
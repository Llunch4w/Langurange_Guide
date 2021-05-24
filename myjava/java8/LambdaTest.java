/**
 * @ Author LuckyQ
 * @ Date   2021-05-23 21:04
 * @ Description Lambda表达式的使用
 */

package myjava.java8;

public class LambdaTest {
    public static void main(String[] args){
        MyInterface myInterface;
        myInterface = (name, age) -> {
            System.out.println(name + " is " + age + " years old.");
        };
        myInterface.lambda("小明", 10);
    }
}

interface MyInterface{
    void lambda(String name,int age);
}

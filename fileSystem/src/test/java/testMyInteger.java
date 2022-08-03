import java.util.Scanner;
//7:MyInteger
class MyInteger{
    private int value;                   //存储这个对象表示的int值
    public MyInteger(int value) {
        this.value = value;
    }                                     //为指定的int值创建MyInteger对象的构造方法
    public int getValue() {
        return value;
    }                                    //返回int值的获取方法
    public boolean isEven() {
        return isEven(value);
    }                                   //调用静态方法判断对象中的值是否为偶数
    public boolean isOdd() {
        return isOdd(value);
    }                                   //调用静态方法判断对象中的值是否为奇数
    public boolean isPrime() {
        return isPrime(value);
    }                                   //调用静态方法判断对象中的值是否为素数
    public static boolean isEven(int value) {
        if(value % 2 == 0)
            return true;
        else
            return false;
    }                                   //判断指定值是否为偶数
    public static boolean isOdd(int value) {
        if(value % 2 != 0)
            return true;
        else
            return false;
    }                                   //判断指定值是否为奇数
    public static boolean isPrime(int value) {
        for(int i = 2; i < value - 1; i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }                                   //判断指定值是否为素数
    public static boolean isEven(MyInteger m) {
        if(m.getValue() % 2 == 0)
            return true;
        else
            return false;
    }                                   //判断指定值是否为偶数
    public static boolean isOdd(MyInteger m) {
        if(m.getValue() % 2 != 0)
            return true;
        else
            return false;
    }                                   //判断指定值是否为奇数
    public static boolean isPrime(MyInteger m) {
        for(int i = 2; i < m.getValue() - 1; i++) {
            if(m.getValue() % 2 == 0)
                return false;
        }
        return true;
    }                                   //判断指定值是否为素数
    public boolean equals(int value) {
        if(this.value == value)
            return true;
        else
            return false;
    }                                   //判断该对象的值是否与指定值相等
    public boolean equals(MyInteger m) {
        if(this.value == m.getValue())
            return true;
        else
            return false;
    }                                   //判断该对象的值是否与指定值相等
}

public class testMyInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyInteger n1 = new MyInteger(input.nextInt());         //创建一个对象n1
        System.out.println("n1是偶数吗？" + '\t' + n1.isEven());     //调用非静态方法判断n1是否为偶数
        System.out.println("n1是素数吗？" + '\t' + n1.isPrime());     //调用非静态方法判断n1是否为素数
        System.out.println("n1是素数吗？" + '\t' + MyInteger.isPrime(n1));     //调用静态方法判断n1是否为素数
        MyInteger n2 = new MyInteger(input.nextInt());         //创建一个对象n2
        System.out.println("n2是奇数吗？" + '\t' + n2.isOdd());     //调用非静态方法判断n2是否为奇数
        System.out.println("45是奇数吗？" + '\t' + MyInteger.isOdd(45));     //调用静态方法判断n2是否为奇数
        System.out.println("n1与n2相等吗？" + '\t' + n1.equals(n2));     //调用非静态方法判断n1与n2是否相等
        System.out.println("n1等于5吗？" + '\t' + n1.equals(5));     //调用非静态方法判断n1是否等于5
    }
}

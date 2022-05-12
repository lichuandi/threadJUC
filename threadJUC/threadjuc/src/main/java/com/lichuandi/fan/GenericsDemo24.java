package com.lichuandi.fan;

/**
 * @author digege
 * @date 2021/11/10 15:38
 * @description：TODO
 * @page com.lichuandi.fan
 * version：1
 */
interface Info<T>{        // 在接口上定义泛型
    public T getVar() ; // 定义抽象方法，抽象方法的返回值就是泛型类型
}
class InfoImpl<T> implements Info<T>{   // 定义泛型接口的子类
    private T var ;             // 定义属性
    public InfoImpl(T var){     // 通过构造方法设置属性内容
        this.setVar(var) ;
    }
    public void setVar(T var){
        this.var = var ;
    }
    @Override
    public T getVar(){
        return this.var ;
    }
}
public class GenericsDemo24{
    public static void main(String arsg[]){
        Info<String> i = null;        // 声明接口对象
        i = new InfoImpl<String>("汤姆") ;  // 通过子类实例化对象
        System.out.println("内容：" + i.getVar()) ;
    }
}
//上限
class Info1<T extends Number>{    // 此处泛型只能是数字类型
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    @Override
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}
class demo1{
    public static void main(String args[]){
        Info1<Integer> i1 = new Info1<Integer>() ;        // 声明Integer的泛型对象
        i1.setVar(15);
    System.out.println(i1.getVar());
    //
        Info1<Double> i12 = new Info1<Double>() ;        // 声明Integer的泛型对象
        i12.setVar(15.5);
        System.out.println(i12.getVar());
    }
}
//下限
class Info2<T>{
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    @Override
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}
class GenericsDemo21{
    public static void main(String args[]){
        Info2<String> i1 = new Info2<String>() ;        // 声明String的泛型对象
        Info2<Object> i2 = new Info2<Object>() ;        // 声明Object的泛型对象
        i1.setVar("hello") ;
        i2.setVar(new Object()) ;
        fun(i1) ;
        fun(i2) ;
    }
    public static void fun(Info2<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.print(temp + ", ") ;
    }
}
// <?> 无限制通配符
// <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
// <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
//
//// 使用原则《Effictive Java》
//// 为了获得最大限度的灵活性，要在表示 生产者或者消费者 的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
// 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
// 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
// 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。

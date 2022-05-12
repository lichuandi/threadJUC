package com.lichuandi.jdk8.myjava8;

/**
 * @author digege
 * @date 2022/1/21 23:11
 * @description：lambda使用
 * @page com.lichuandi.jdk8.myjava8
 * version：1
 */
public class MyFunctionInterfaceDemo {
    // 函数式接口可以当参数使用
    public static void show(MyFunctionInterface myFunction) {
        myFunction.method();
    }
    public static void main(String[] args) {
        show(new MyFunctionInterfaceImpl());
        // 调用show方法，参数是一个接口，所以传递接口的实现类对象
        show (new MyFunctionInterface() {
            @Override
            public void method() {
            System.out.println("我是匿名内部重写抽象方法");
          }
        });
        // 调用show方法，参数是一个函数式接口，可以使用lambda
        // ()是抽象方法的，{}是方法体，
        show (() -> {
          System.out.println("使用lambda方式重写抽象方法");
         // System.out.println();
        });
        // 简化lambda,{}中只有一行则，可以省略，不然{要报警告
        show(() -> System.out.println("简化的lambda"));

    }


}

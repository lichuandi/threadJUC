package com.lichuandi.other;

public class ABC {

    public static void main(String[] args) {

        B b=new B();
        b.run();
        A a=b;
        a.run();
        System.out.println(b.getClass()==B.class);
        System.out.println(a.getClass()==A.class);

    }
}
class A {
    public A(){
        System.out.println("1");


    }
    public void run(){
        System.out.println("2");

    }

}
class B extends  A {
    public B(){
        System.out.println("3");
    }
    @Override
    public void run() {
        //super.run();

        System.out.println("4");
    }
}
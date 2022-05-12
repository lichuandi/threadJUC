package com.lichuandi.jdk8.defaults;

/**
 * @author digege
 * @date 2021/11/3 10:01
 * @description：TODO
 * @page com.lichuandi.jdk8.defaults
 * version：1
 */
public interface DefaultDemo {
    /**
     * 默认方法functions，实现了可以不重写
     */
    default void functions(){
    System.out.println("我是在接口中定义的默认方法");
    }
}
class ClassDefaultImpl implements DefaultDemo{
  public static void main(String[] args) {
    //
      ClassDefaultImpl classDefault = new ClassDefaultImpl();
      classDefault.functions();
  }
}
interface A {
    /**
     * 接口A的默认方法hello
     */
    default void hello(){
    System.out.println("你好，digege,我是A接口的默认方法");
    }
}

interface B extends A{
    /**
     * 接口B的重写默认方法hello
     */
    @Override
    default void hello(){
        System.out.println("你好，lichuandi，我是B接口的默认方法");
    }
}
interface B1{
    /**
     * 接口B1的重写默认方法hello
     */
    default void hello(){
        System.out.println("你好，lichuandi，我是B1接口的默认方法");
    }
}
/**
 * 多重继承实现了A和B的hello方法
 * 实现类C实现了A和B接口
 */
class C implements A,B{
  public static void main(String[] args) {
    //调用是是重写的默认方法
      new C().hello();
      //如果要调用基类的默认方法X.super.m(…),


  }
}
//可以多实现相同的方法，但要指定调用指定的接口的方法
class C1 implements A,B,B1{
    @Override
    public void hello(){
        B1.super.hello();
    }
    public static void main(String[] args) {
        //如果要调用基类的默认方法X.super.m(…),
        new C().hello();
    }
}
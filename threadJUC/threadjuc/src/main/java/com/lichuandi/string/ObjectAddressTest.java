package com.lichuandi.string;

import lombok.Data;

/**
 * @author digege
 * @date 2021/11/10 15:01
 * @description：Java 的参数是以值传递的形式传入方法中，而不是引用传递。
 * @page com.lichuandi.string
 * version：
 */
public class ObjectAddressTest {
  public static void main(String[] args) {
    //
      Dog dog = new Dog("A");
      System.out.println(dog.getObjectAddress());
       func(dog);
      System.out.println(dog.getObjectAddress());
    System.out.println(dog.getName());
  }

  private static  void  func(Dog dog){
    System.out.println(dog.getObjectAddress());
    dog=new Dog("B");
    System.out.println(dog.getObjectAddress());
    System.out.println(dog.getName());
  }
}
@Data
class Dog{
    private String name;

    String getObjectAddress(){
        return super.toString();
    }

    public Dog(String name) {
        this.name = name;
    }
}

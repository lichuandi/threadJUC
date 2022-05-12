package com.lichuandi.jdk8.collectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @Auther digege
 * @Date 2021/5/28
 * @Description：
 * @page com.lichuandi.jdk8.collectors
 * version：1
 */
public class PersonDemo {
  public static void main(String[] args) {
    //
      Collection<Person> collection = new ArrayList();
      collection.add(new Person("张三", 22, "男"));
      collection.add(new Person("李四", 19, "女"));
      collection.add(new Person("王五", 34, "男"));
      collection.add(new Person("赵六", 30, "男"));
      collection.add(new Person("田七", 25, "女"));
    //过滤30岁以上的求职者
      Iterator<Person> iterator = collection.iterator();
      while (iterator.hasNext()) {
          Person person = iterator.next();
          if (person.getAge() >= 30){
              iterator.remove();}
      }
      System.out.println(collection.toString());//查看结果
     //使用removeif
      collection.removeIf(
              person -> person.getAge() >= 30
      );//过滤30岁以上的求职者

      System.out.println(collection.toString());//查看结果
      //不使用lamda
      collection.removeIf(new Predicate<Person>() {
          @Override
          public boolean test(Person person) {
              return person.getAge()>=30;//过滤30岁以上的求职者
          }
      });

      System.out.println(collection.toString());//查看结果

  }
}

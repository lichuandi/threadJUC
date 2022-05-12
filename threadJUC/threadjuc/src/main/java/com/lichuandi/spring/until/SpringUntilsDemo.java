package com.lichuandi.spring.until;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther digege
 * @Date 2021/6/2
 * @Description：
 * @page com.lichuandi.spring.until
 * version：1
 */
public class SpringUntilsDemo {
  public static void main(String[] args) {
    //
    List<String> objects = new ArrayList<>();
    objects.add("A");
    objects.add("B");
    objects.add("C");
    List<String> strings = new ArrayList<>();
    System.out.println(objects.toString());
    BeanUtils.copyProperties(objects,strings);
    System.out.println(strings.toString());

  }
}
@Data
class User{
  private String Name;
  private Integer age;
  private String sex;

  public User(){}
  public User(String name, Integer age, String sex) {
    Name = name;
    this.age = age;
    this.sex = sex;
  }
}

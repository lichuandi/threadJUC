package com.lichuandi.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther digege
 * @Date 2021/5/18
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class StreamDemo {
  public static void main(String[] args) {
      List<User> list = new ArrayList<User>(){
          {
              add(new User(1L,"张三",10, "清华大学"));
              add(new User(2L,"李四",12, "清华大学"));
              add(new User(3L,"王五",15, "清华大学"));
              add(new User(4L,"赵六",12, "清华大学"));
              add(new User(5L,"田七",25, "北京大学"));
              add(new User(6L,"小明",16, "北京大学"));
              add(new User(7L,"小红",14, "北京大学"));
              add(new User(8L,"小华",14, "浙江大学"));
              add(new User(9L,"小丽",17, "浙江大学"));
              add(new User(10L,"小何",10, "浙江大学"));
          }
      };
      //开始版本
      List<Long> userIdList = new ArrayList<>();
      for (User user:list ) {
          userIdList.add(user.getId());
      }
      //1.8  使用forEach
      List<Long> userIdList18 = new ArrayList<>();
     // list.forEach(user -> user.getId());
      list.forEach(user -> userIdList.add(user.getId()));
      //1.8使用流stream
      List<Long> userIdListStrea = new ArrayList<>();
      //list.stream转为流，把流map中间转化存入getID,最终端加入list
      List<Long> collect = list.stream().map(User::getId).collect(Collectors.toList());
      //过滤所有清华大学的学生user
      List<User> userList1 = list.stream().filter(user -> "清华大学".equals(user.getSchool())).collect(Collectors.toList());
    userList1.forEach(user -> System.out.println(user.getName()));
      //去重所有user年龄集合
      List<Integer> collectAge = list.stream().map(User::getAge).distinct().collect(Collectors.toList());
    System.out.println("UserAge="+collectAge);
      //limit 前n个数据
      List<User> userList3 = list.stream().filter(user -> user.getAge() % 2 == 0).limit(2).collect(Collectors.toList());
      userList3.forEach(user -> System.out.print(user.getName()+ '、'));
      //排序按年龄大到小
      List<User> userList4 = list.stream().sorted((s1,s2)->s2.getAge()-s1.getAge()).collect(Collectors.toList());
      userList4.forEach(user -> System.out.print(user.getName()+ '、'));
      //skip跳过n元素后输出
      List<User> userList5 = list.stream().skip(2).collect(Collectors.toList());
      //map 所有学生的姓名
      List<String> userList6 = list.stream().filter(user -> "清华大学".equals(user.getSchool())).map(User::getName).collect(Collectors.toList());
      //清华大学的user年龄总和list.stream().filter().mapToInt().sum();
      list.stream().filter(user -> "".equals(user.getSchool())).mapToInt(User::getAge).sum();
    System.out.println("清华大学所有学生年龄总和"+userList6);
      //flatMap每个值转为流再合成一个流
      String[] strings = {"Hello", "World"};
      List l11 = Arrays.stream(strings).map(str -> str.split("")).map(str2-> Arrays.stream(str2)).distinct().collect(Collectors.toList());
      List l2 = Arrays.asList(strings).stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
      System.out.println(l11.toString());
      System.out.println(l2.toString());
      //查找
      System.out.println("判断是否所有user的年龄都大于9岁");
      Boolean b = list.stream().allMatch(user -> user.getAge() >9);
      System.out.println(b);
      System.out.println("判断是否有user的年龄是大于15岁");
      Boolean bo = list.stream().anyMatch(user -> user.getAge() >15);
      System.out.println(bo);
      System.out.println("判断是否不存在年龄是15岁的user");
      Boolean boo = list.stream().noneMatch(user -> user.getAge() == 15);
      System.out.println(boo);
      System.out.println("返回年龄大于12岁的user中的第一个");
      Optional<User> first = list.stream().filter(u -> u.getAge() > 10).findFirst();
      User user = first.get();
      System.out.println(user.toString());
      System.out.println("返回年龄大于12岁的user中的任意一个");
      Optional<User> anyOne = list.stream().filter(u -> u.getAge() > 10).findAny();
      User user2 = anyOne.get();
      System.out.println(user2.toString());
      //前面用到的方法
      Integer ages = list.stream().filter(student -> "清华大学".equals(student.getSchool())).mapToInt(User::getAge).sum();
      System.out.println(ages);
      System.out.println("归约 - - 》 start ");
      Integer ages2 = list.stream().filter(student -> "清华大学".equals(student.school)).map(User::getAge).reduce(0,(a,c)->a+c);
      Integer ages3 = list.stream().filter(student -> "清华大学".equals(student.school)).map(User::getAge).reduce(0,Integer::sum);
      Integer ages4 = list.stream().filter(student -> "清华大学".equals(student.school)).map(User::getAge).reduce(Integer::sum).get();
      System.out.println(ages2);
      System.out.println(ages3);
      System.out.println(ages4);
      System.out.println("归约 - - 》 end ");
      //counting
      System.out.println("user的总人数");
      long COUNT = list.stream().count();//简化版本
      long COUNT2 = list.stream().collect(Collectors.counting());//原始版本
      System.out.println(COUNT);
      System.out.println(COUNT2);
      System.out.println("user的年龄最大值和最小值");
      Integer maxAge =list.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge())).get().getAge();
      Integer maxAge2 = list.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge))).get().getAge();
      Integer minAge = list.stream().collect(Collectors.minBy((S1,S2) -> S1.getAge()- S2.getAge())).get().getAge();
      Integer minAge2 = list.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge))).get().getAge();
      System.out.println("maxAge = " + maxAge);
      System.out.println("maxAge2 = " + maxAge2);
      System.out.println("minAge = " + minAge);
      System.out.println("minAge2 = " + minAge2);
      System.out.println("user的年龄总和");
      Integer sumAge =list.stream().collect(Collectors.summingInt(User::getAge));
      System.out.println("sumAge = " + sumAge);
      System.out.println("user的年龄平均值");
      double averageAge = list.stream().collect(Collectors.averagingDouble(User::getAge));
      System.out.println("averageAge = " + averageAge);
      System.out.println("一次性得到元素个数、总和、均值、最大值、最小值");
      long l1 = System.currentTimeMillis();
      IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(User::getAge));
      long l111 = System.currentTimeMillis();
      System.out.println("计算这5个值消耗时间为" + (l111-l1));
      System.out.println("summaryStatistics = " + summaryStatistics);
      System.out.println("字符串拼接");
      String names = list.stream().map(User::getName).collect(Collectors.joining(","));
      System.out.println("names = " + names);
      System.out.println("分组");
      Map<String, List<User>> collect1 = list.stream().collect(Collectors.groupingBy(User::getSchool));
      Map<String, Map<Integer, Long>> collect2 = list.stream().collect(Collectors.groupingBy(User::getSchool, Collectors.groupingBy(User::getAge, Collectors.counting())));
      Map<String, Map<Integer, Map<String, Long>>> collect4 = list.stream().collect(Collectors.groupingBy(User::getSchool, Collectors.groupingBy(User::getAge, Collectors.groupingBy(User::getName,Collectors.counting()))));
      Map<String, Long> collect3 = list.stream().collect(Collectors.groupingBy(User::getSchool, Collectors.counting()));
      System.out.println("collect1 = " + collect1);
      System.out.println("collect2 = " + collect2);
      System.out.println("collect3 = " + collect3);
      System.out.println("collect4 = " + collect4);
      System.out.println("分区");
      Map<Boolean, List<User>> collect5 = list.stream().collect(Collectors.partitioningBy(user1 -> "清华大学".equals(user1.school)));
      System.out.println("collect5 = " + collect5);
  }
}

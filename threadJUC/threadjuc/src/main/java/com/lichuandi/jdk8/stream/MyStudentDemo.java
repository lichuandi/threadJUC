package com.lichuandi.jdk8.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.boot.test.json.GsonTester;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.*;

/**
 * @author digege
 * @date 2022/3/9 22:14
 * @description：TODO
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class MyStudentDemo {
  public static void main(String[] args) {
    //
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    System.out.println(timestamp);
    String time = "2022-03-10 08:12:22.101";
      Timestamp timestamp1 = Timestamp.valueOf(time);
    System.out.println(timestamp1);

      List<MyStudent> list = Lists.newArrayList();
     MyStudent myStudent = new MyStudent();
      myStudent.setName("ddd");
      myStudent.setAge("第一");
      myStudent.setSex("0");
      myStudent.setBirthday(Timestamp.valueOf("2022-03-10 08:12:22.101"));
      list.add(myStudent);
      myStudent = new MyStudent();
      myStudent.setName("lilili");
      myStudent.setAge("第二");
      myStudent.setSex("1");
      myStudent.setBirthday(Timestamp.valueOf("2022-03-10 10:12:22.101"));
      list.add(myStudent);
      myStudent = new MyStudent();
      myStudent.setName("cicici");
      myStudent.setAge("第二");
      myStudent.setSex("1");
      myStudent.setBirthday(Timestamp.valueOf("2022-03-10 10:12:22.101"));
    list.add(myStudent);
      List<MyStudent> list22 = Lists.newArrayList();
    MyStudent student = new MyStudent();
    Optional<MyStudent> max = list22.parallelStream().max(Comparator.<MyStudent, Integer>comparing(
            cimQTimeRestriction -> Long.valueOf(cimQTimeRestriction.getBirthday().getTime()).intValue()));
      Optional<MyStudent> min = of(list.parallelStream().min(
              Comparator.<MyStudent, Integer>comparing(cimQTimeRestriction ->
                      Long.valueOf(cimQTimeRestriction.getBirthday().getTime()).intValue())).orElse(student));
   // Optional.ofNullable(list).map().orElse(student);
      System.out.println(min.get().getSex());
      //System.out.println(max.get().getSex());
    /*if (min.isPresent()) {
      System.out.println("#################");
        MyStudent student1 = min.get();
        if (null != student1) {
            student.setAge(new BigDecimal(student1.getBirthday().getTime()- timestamp.getTime())
                    .divide(BigDecimal.valueOf(60000),BigDecimal.ROUND_UP).toString());
        }

    }*/
      if (max.isPresent()) {
        MyStudent myStudent1 = max.get();
       // BigDecimal remainTime = new BigDecimal( myStudent1.getBirthday().getTime()- Timestamp.valueOf("2022-03-10 08:12:22.101").getTime());
        BigDecimal remainTime = new BigDecimal( myStudent1.getBirthday().getTime()- timestamp.getTime());
        //int multiply = remainTime.divide(remainTime, 60, BigDecimal.ROUND_UP).multiply(BigDecimal.valueOf(100)).intValue();
        //BigDecimal divide = remainTime.divide(remainTime,6000, BigDecimal.ROUND_UP);
        BigDecimal divide = remainTime.divide(BigDecimal.valueOf(60000), BigDecimal.ROUND_UP);
        student.setSex(remainTime.divide(BigDecimal.valueOf(60000), BigDecimal.ROUND_UP).toString());
      }
    //  System.out.println(min.get().getSex());
    // list.stream().filter(myStudent1 -> myStudent1.getBirthday()).
    // Optional<MyStudent> myStudent =
   /* of(list.parallelStream()
            .min(
                Comparator.<MyStudent, Integer>comparing(
                    cimQTimeRestriction ->
                        Long.valueOf(cimQTimeRestriction.getBirthday().getTime()).intValue()))
            .orElse(student))
        .ifPresent(
            myStudent2 -> {
              if (null == myStudent2) {

              } else {
                student.setSex(new BigDecimal(myStudent2.getBirthday().getTime()- timestamp.getTime())
                        .divide(BigDecimal.valueOf(60000),BigDecimal.ROUND_UP).toString());
              }
            });*/
    of(list.parallelStream().min(
            Comparator.<MyStudent, Integer>comparing(cimQTimeRestriction ->
                    Long.valueOf(cimQTimeRestriction.getBirthday().getTime()).intValue())).orElse(student)).ifPresent(myStudent2 -> {
      student.setAge(new BigDecimal(myStudent2.getBirthday().getTime()- timestamp.getTime())
              .divide(BigDecimal.valueOf(60000),BigDecimal.ROUND_UP).toString());
    });


    System.out.println("我是最终的值"+student);
      List<MyStudent> list2 = Lists.newArrayList();
      List<MyStudent> collect = list.stream().map(lo ->
                      myStudent(lo.getAge())
              //  list2.addAll(list22)
      ).collect(Collectors.toList());
      System.out.println(collect);
      JSONArray.toJSON(collect);
    System.out.println(JSONArray.toJSON(collect));
   /* list.stream().map(lot -> {

                  list2.addAll(myStudent2(lot.getAge()));
                  return list2;
              }
      ).collect(Collectors.toList());*/
      for (MyStudent myStudent1 : list) {
          List<MyStudent> myStudents = myStudent2(myStudent1.getAge());
          list2.addAll(myStudents);
      }
      list.stream().map(myStudent1 -> myStudent2(myStudent1.getAge())).forEach(list2::addAll);
      list.stream().forEach(lot -> list2.addAll(myStudent2(lot.getAge())));

      list.stream().forEach(lot -> list2.addAll(myStudent2(lot.getAge())));
      System.out.println(list2);
      //System.out.println(collect1);
      System.out.println(JSONArray.toJSON(list2));
     // 分组
      Map<Object, List<MyStudent>> collect1 = list.stream().collect(Collectors.groupingBy(st ->
          st.getAge()));
    System.out.println("我分组了" + collect1);
  }
    public static MyStudent myStudent(String s){
        MyStudent myStudent = new MyStudent();
        myStudent.setName("llll");
        myStudent.setAge(s);
        myStudent.setSex("0");
        List<ST > stringList  = new ArrayList<>();
        ST st = new ST();
        st.setAa("aa");
        st.setBb("bb");
        stringList.add(st);
        st = new ST();
        st.setAa("aaa");
        st.setBb("bbb");
        stringList.add(st);
        myStudent.setSt(stringList);

        return myStudent;
    }
    public static List<MyStudent> myStudent3(){
        List<MyStudent> list =new ArrayList<>();

        list.add(myStudent("111"));
    System.out.println(list);
    return list;
    }
    public static List<MyStudent> myStudent2(String s){
        List<MyStudent> list = new ArrayList<>();
        MyStudent myStudent = new MyStudent();
        myStudent.setName("llll");
        myStudent.setAge(s);
        myStudent.setSex("0");

        List<ST > stringList  = new ArrayList<>();
        ST st = new ST();
        st.setAa("aa");
        st.setBb("bb");

        stringList.add(st);
        st = new ST();
        st.setAa("aaa");
        st.setBb("bbb");
        stringList.add(st);

        myStudent.setSt(stringList);

        list.add(myStudent);
        MyStudent myStudent2 = new MyStudent();
        myStudent2.setName("llll");
        myStudent2.setAge(s);
        myStudent2.setSex("0");
        List<ST > stringList2  = new ArrayList<>();
        ST st2 = new ST();
        st2.setAa("aa");
        st2.setBb("bb");
        stringList2.add(st);
        st2 = new ST();
        st2.setAa("aaa");
        st2.setBb("bbb");
        stringList2.add(st);
        myStudent2.setSt(stringList);
        list.add(myStudent2);
        return list;
    }
}


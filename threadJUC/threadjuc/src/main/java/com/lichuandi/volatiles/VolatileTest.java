package com.lichuandi.volatiles;

import com.lichuandi.reflect.test03.Student;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.volatiles version：
 */
public class VolatileTest {
    boolean runing=true;
 // volatile   boolean runing=true;
    void m(){
        System.out.println("M 开始");
        while (runing){

        }
        System.out.println("end 结束");
    }

    public static void main(String[] args) {
        VolatileTest volatileTest= new VolatileTest();
        new Thread(volatileTest::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.runing =false;
        List<String> stringList = Arrays.asList("1111", "333");
    System.out.println(stringList);
        Stu stu1 = new Stu(11, 20, "11");
        Stu stu2 = new Stu(12, 25, "111");
        Stu stu3 = new Stu(12, 28, "111");
        Stu stu5 = new Stu(11, 25, "111");
        Stu stu4 = new Stu(11, 28, "11");

        List<Stu> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
        boolean b = list.stream().anyMatch(stu -> stu.s1 == 27);
    System.out.println(b
    );
        ArrayList<Stu> collect = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(Stu::getS1))), ArrayList::new));
    System.out.println(collect);

        ArrayList<Stu> collect2 = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(o-> o.getS1()+";"+o.getSs()))), ArrayList::new));
        System.out.println(collect2);
  /*  list.stream().map(list->{

    }).collect()*/


        StringBuilder builder = new StringBuilder();
        builder.append("").append("").append("").append("").append("").append("").append("").append("").append("")
                .append("").append("").append("")
                .append("")
                .append("");
        float a1 = 1.0f - 0.9f;
        float b1 = 0.9f - 0.8f;
        float diff = 1e-6f;
        if (Math.abs(a1 - b1) < diff) {
            System.out.println("true");
        }
        if (a1 == b1) {
            System.out.println("SSSSSSSSSSSSSS");
        }

        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend11 = new BigDecimal(0.1);
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
        System.out.println(recommend1);
        System.out.println(recommend2);
        System.out.println(recommend11);
    }
}
@Data
class  Stu {
     int s;
    int s1;
    String ss;

    public Stu(int s, int s1, String ss) {
        this.s = s;
        this.s1 = s1;
        this.ss = ss;
    }
}

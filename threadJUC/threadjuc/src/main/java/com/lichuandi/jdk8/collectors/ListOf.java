package com.lichuandi.jdk8.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lichu
 * @author digege
 * @Date 2021/5/28
 * @Description：
 * @page com.lichuandi.jdk8.collectors
 * version：1
 */
public class ListOf {
  public static void main(String[] args) {
    //
    List<String> collect = Stream.of("A", "B", "C").collect(Collectors.toList());
    System.out.println(collect);
    //外部迭代
   // ArrayList<Person> list = new ArrayList<>();
    List<Person> people = Arrays.asList(new Person("li", 11, "1"),
            new Person("bb", 15, "0"),
            new Person("cc", 25, "1"));
    for (Person p :people ) {
      p.setName("lichuandi");
    }
    System.out.println(people);
    people.forEach(person -> person.setName("digege"));
    System.out.println(people);
    //
    Stream<Person> personStream = people.stream().filter(p -> p.getAge() > 20);
    // System.out.println(personStream.findFirst());
    // System.out.println(personStream.map());
    // System.out.println(personStream.count());
    // ******************
    System.out.println("*******************");
   // people.forEach(n -> System.out.println(n));
    //people.forEach(System.out::println);
    List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
    int factor = 2;
    //primes.forEach(element -> { factor++; });
    primes.forEach(element -> { System.out.println(factor*element); });
    long t0 = System.nanoTime();

//初始化一个范围100万整数流,求能被2整除的数字，toArray()是终点方法

    int a[]= IntStream.range(0, 1_000_000).filter(p -> p % 2==0).toArray();

    long t1 = System.nanoTime();

//和上面功能一样，这里是用并行流来计算

    int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();

    long t2 = System.nanoTime();

//我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

    System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

  }
  //内部迭代persons.forEach(p->p.setLastName("Doe"));
}

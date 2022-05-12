package com.lichuandi.jdk8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Auther digege
 * @Date 2021/6/26
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class TableList {
  public static void main(String[] args) {
    //
      List<Tables> objects = new ArrayList<>();
      Tables tables = new Tables();
      tables.setColumnA("AA");
      tables.setColumnB("BB");
      tables.setColumnC("CC");
      tables.setColumnD("DD");
      Tables tables2 = new Tables();
      tables2.setColumnA("AA");
      tables2.setColumnB("BB");
      tables2.setColumnC("CC");
      tables2.setColumnD("DD");
      Tables tables3 = new Tables();
      tables3.setColumnA("AAA");
      tables3.setColumnB("BBB");
      tables3.setColumnC("CCC");
      tables3.setColumnD("DDD");
      Tables tables4 = new Tables();
      tables4.setColumnA("AAAA");
      tables4.setColumnB("BBBB");
      tables4.setColumnC("CCCC");
      tables4.setColumnD("DDDD");
      objects.add(tables);
      objects.add(tables2);
      objects.add(tables3);
      objects.add(tables4);
    System.out.println(objects);
      Iterator<Tables> iterator = objects.iterator();
      List<Map<String, String>> stringHashMap = new ArrayList<>();
      while (iterator.hasNext()){
          Map<String, String> stringStringHashMap = new HashMap<>();
          Tables next = iterator.next();
          stringStringHashMap.put("columnA",next.getColumnA());
          stringStringHashMap.put("columnB",next.getColumnB());
          stringStringHashMap.put("columnC",next.getColumnC());
          stringStringHashMap.put("columnD",next.getColumnD());
          stringHashMap.add(stringStringHashMap);
      }
    System.out.println(stringHashMap);
     /* Map<String, List<String>> locationMap = objects.stream()
              .map(s -> s1.split(":"))
              .collect(Collectors.groupingBy(a -> a1[0],
                      Collectors.mapping(a -> a1[1], Collectors.toList())));
    System.out.println(locationMap);*/
      //objects.stream().map(obj->{}).collect(Collectors.toMap())
      //objects.stream().collect(Collectors.toMap(User::getAge,  .identity(),(key1, key2)->key2, LinkedHashMap::new));
     // Map<String, String> collect = objects.stream().collect(Collectors.toMap(Tables::getColumnA, Tables::getColumnB, (oldValue, newValue) -> newValue));
    //System.out.println(collect);
      //Map<String, String> map = list.stream().collect(Collectors.toMap(ProductInfoDo::getProductId, ProductInfoDo::getExpireDay,(oldValue, newValue) -> newValue));
     // Map<String, Tables> collect = objects.stream().collect(Collectors.toMap(Tables::getColumnA, tables1 -> tables1));
    //System.out.println(collect);
  }
}

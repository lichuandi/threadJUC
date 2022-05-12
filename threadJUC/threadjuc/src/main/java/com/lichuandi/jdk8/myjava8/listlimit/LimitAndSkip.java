package com.lichuandi.jdk8.myjava8.listlimit;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sun.plugin2.os.windows.FLASHWINFO.size;

/**
 * @author digege
 * @date 2022/3/17 23:22
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.listlimit
 * version：1
 */
public class LimitAndSkip {
  public static void main(String[] args) {
      List<Integer> objects = Lists.newArrayList();
    for (int i = 1; i <=500 ; i++) {
        objects.add(i);
      //
    }
    for (int i = 0; i < objects.size() ; i+= 100) {
        List<Integer> newList;
        try {
            newList = objects.subList(1, i + 100);
       // System.out.println(newList);
        } catch (IndexOutOfBoundsException e) {
            newList = objects.subList(1, size());
          //  System.out.println(newList);
        }

    }
      int s=3;
      for(int i = 1; i < objects.size() ; i+= 3) {
          objects.stream().skip((i-1)*3).limit(3).forEach(s1 -> System.out.println("每三个执行"+s1));
      }

      List<List<Object>> lists = averageAssign(objects, 2);
    System.out.println(lists);

      Stream<Integer> limit = Stream.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).limit(5);
    System.out.println(limit);
      Stream.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).limit(5).forEach(s2 -> System.out.println(s2));
    Stream.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).parallel().limit(5).forEach(s3 -> System.out.println(s3));
    System.out.println("**********");
    Stream.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).limit(5).skip(2).forEach(s4 -> System.out.println(s4));
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    System.out.println(subCollection(list,3));
  }

    private static <T> List<List<T>> averageAssign(List<Integer> source, int n) {

        List<List<T>> result = new ArrayList<>();
        // 先计算余数
        int remaider = source.size()%n;
        //商
        int number = source.size()/n;
        int offset = 0;
    for (int i = 0; i < n; i++) {
      List<T> value = null;
      if (remaider > 0) {
          source.subList(i*number + offset, (i+1)*number + offset +1);
          remaider--;
          offset++;
      } else {
          source.subList(i*number + offset, (i+1)*number + offset);
      }
      result.add(value);
    }
        return result;

    }

    /**
     *
     * @param size 需要分割的集合长度
     * @param maxNum 集合最大的数量
     * @return 切分次数
     */
    private  static  Integer countStep (Integer size, Integer maxNum) {
      return (size + maxNum -1) / maxNum;
    }
    private  static  <T> Collection<Collection<T>> subCollection (Collection<T> collections, int maxNum) {

        Integer limit = countStep(collections.size(), maxNum);
       /* Collection<Collection<T>> mgList = new ArrayList<>();
        Stream.iterate(0, n -> n+1).limit(limit).forEach(integer1 -> {
            mgList.add(collections.stream().skip(i* maxNum).limit(maxNum).collect(Collectors.toList()));
        });
        return mgList;*/
        Collection<Collection<T>> collect = Stream.iterate(
                0, n -> n + 1
        ).limit(limit).parallel().map(
                a ->
                collections.stream().skip(a * maxNum).limit(maxNum).parallel()
                        .collect(Collectors.toList())
        )
                .collect(Collectors.toList());
        return collect;
    }
}

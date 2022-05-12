package com.lichuandi.juc;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther digege
 * @Date 2021/8/3
 * @Description：
 * @page com.lichuandi.juc
 * version：1
 */
public class JUCTest1 {
  public static void main(String[] args) {
    //
      CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
      arrayList.add(11);
      arrayList.add("333");
      arrayList.add(true);
      arrayList.add(false);
      System.out.println(arrayList);
      Set<Object> arraySet = new CopyOnWriteArraySet<>();
      arraySet.addAll(arrayList);
      arraySet.add(true);
      System.out.println(arraySet);
      //***********
      Set<String> stringSet = new CopyOnWriteArraySet<String>();
      HashMap<String, String> hashMap = new HashMap<>();
      hashMap.put("Down","p1");
      hashMap.put("Down","p2");
      hashMap.put("Down","p3");
      hashMap.put("Up","p4");
      hashMap.put("input","Down");
      hashMap.put("output","Down");
      hashMap.put("input","Down");
      hashMap.put("output","up");
    System.out.println(
            hashMap
    );
  }
}

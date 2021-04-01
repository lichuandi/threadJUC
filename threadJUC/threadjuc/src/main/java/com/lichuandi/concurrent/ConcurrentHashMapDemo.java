package com.lichuandi.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("li",11);
        System.out.println(concurrentHashMap.get("li"));
    }
}

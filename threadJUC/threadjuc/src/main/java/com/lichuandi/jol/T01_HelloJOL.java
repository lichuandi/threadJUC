package com.lichuandi.jol;

import  org.openjdk.jol.info.ClassLayout;
/**
 * @author lichu
 */
public class T01_HelloJOL {
    public static void main(String[] args) {
        Object o=new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}

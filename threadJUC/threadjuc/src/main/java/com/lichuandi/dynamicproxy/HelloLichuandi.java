package com.lichuandi.dynamicproxy;

/**
 * @author digege
 * @date 2021/9/3 14:57
 * @description：TODO
 * @page com.lichuandi.dynamicproxy
 * version：1
 */
public class HelloLichuandi implements DyProxy{
    @Override
    public void hello(String name) {
    System.out.println("Hello "+name);
    }
}

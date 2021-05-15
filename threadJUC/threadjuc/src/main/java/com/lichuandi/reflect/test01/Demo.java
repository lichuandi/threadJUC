package com.lichuandi.reflect.test01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        //定义一个字符串，用来模拟前台的支付方式：
        String str = "com.lichuandi.reflect.test01.AliPay";  //字符串：实际上：就是微信类的全限定路径

        //下面的代码就是利用反射：
        Class  cls = Class.forName(str);
        Object o = cls.newInstance();
        Method method = cls.getMethod("payOnline");
        method.invoke(o);
    }
}

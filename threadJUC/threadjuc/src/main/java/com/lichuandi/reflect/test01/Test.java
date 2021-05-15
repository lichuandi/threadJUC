package com.lichuandi.reflect.test01;

public class Test {
    public static void main(String[] args) {
        //定义一个字符串，用来模拟前台的支付方式：
        String str = "微信";
        if("微信".equals(str)){//str.equals("微信")---？避免空指针异常
            //微信支付：
            pay(new WeChat());
        }

        if("支付宝".equals(str)){
            //支付宝支付：
            pay(new AliPay());
        }

        if("招商银行".equals(str)){
            pay(new BankCard());
        }



    }
    //方法形参是接口，具体传入的是接口的实现类的对象---》多态的一种形式
    public static void pay(Mtwm m){
        m.payOnline();
    }



}

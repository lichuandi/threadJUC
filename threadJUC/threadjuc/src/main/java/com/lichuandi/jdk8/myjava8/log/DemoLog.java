package com.lichuandi.jdk8.myjava8.log;

/**
 * @author digege
 * @date 2022/1/21 23:36
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.log
 * version：1
 */
public class DemoLog {
    public static  void  showLog(int level, MessageBuilder message) {
        if (level == 1) {
            // 对日志等级进行判断，如果是1级别才打印
            System.out.println(message.builderMessage());
        }

    }

    public static void main(String[] args) {
        String msg1 = "hello";
        String msg2 = "li";
        String msg3 = "chuandi";
        showLog(2,()-> {
          return   msg1 + msg2;
        });
    showLog(
        1,
        () -> {
          System.out.println("不满足不执行");
          return msg1 + msg2 +msg3;
        });
    }
}

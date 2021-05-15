package com.lichuandi.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Auther digege
 * @Date 2021/5/7
 * @Description：com.lichuandi.thread version：1
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取Java线程MXBea
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程的堆和栈
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo t:threadInfos
             ) {
            System.out.println("["+t.getThreadId()+"]"+t.getThreadName());

        }
    }
}

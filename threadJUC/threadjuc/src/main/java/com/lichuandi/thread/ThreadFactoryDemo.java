package com.lichuandi.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory= Executors.defaultThreadFactory();
        threadFactory.newThread(new Printer("lichauandi")).start();
    }
}


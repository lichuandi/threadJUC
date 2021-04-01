package com.lichuandi.thread;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("lichuandi");
        threadLocal.get();
        System.out.println(threadLocal);

    }
}

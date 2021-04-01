package com.lichuandi.thread;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("Hello from new新 thread");
            }
        };

        myThread.start();
        //Thread.yield();
        Thread.sleep(1);
        System.out.println("Hello from main主 thread");
        myThread.join();

    }

}

class A{
   public    void a(){}
}
class  B extends A{
    @Override
    public void  a(){

    }
}
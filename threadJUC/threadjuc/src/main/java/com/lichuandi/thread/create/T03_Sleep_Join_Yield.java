package com.lichuandi.thread.create;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.thread.create version：
 */
public class T03_Sleep_Join_Yield {
    public static void main(String[] args) {

    }
    static  void testSleep(){
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("A"+i);
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    static  void testYield(){
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("A"+i);
                if (i%5==0){Thread.yield();}
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("BBBB"+i);
                if (i%5==0){Thread.yield();}
            }
        }).start();
    }
    static  void testJoin(){
        Thread t1=new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("A"+i);
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(()->{
                try{
                    t1.join();
                    //Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            for (int i = 0; i <100 ; i++) {
                System.out.println("A"+i);
                try{

                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();
    }

}

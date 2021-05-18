package com.lichuandi.threadlocal;

/**
 * @Auther digege
 * @Date 2021/5/18
 * @Description：
 * @page com.lichuandi.threadlocal
 * version：1
 */
import java.util.Locale;

public class ThreadLocalDemo2 {
    private static NumberList numlist=new NumberList();
    private static ThreadLocal<NumberList> local=new ThreadLocal<NumberList>(){
        @Override
        protected NumberList initialValue() {
            return numlist;//初始值
           // return new NumberList(); //每次都new一下 值是一样的
        }
    };

    public static void main(String[] args) {
        Thread[] threads=new Thread[3];
        for(int i=0;i<3;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    NumberList list=local.get();
                    for(int j=0;j<1000;j++){
                        list.init();
                    }
                    local.set(list);
                    System.out.println(Thread.currentThread().getName()+"==="+local.get().num);
                    //
                }
            });
        }
        for(Thread t:threads){
            t.start();
        }

    }

    static class NumberList{
        int num;
        public void init(){
            num++;
        }
    }
}
/** 结果不一样 Thread-2===1000 Thread-1===2000 Thread-0===3000 */

package com.lichuandi.concurrent.juc.automic.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @Auther digege
 * @Date 2021/2/25
 * @Description：com.lichuandi.concurrent.juc.automic.atomicInteger version：1
 */
public class AtomicIntegerDemo {
    public static class AtomicIntegerMonitor
    {
        private AtomicInteger x = new AtomicInteger();

        public void inc()
        {
            x.incrementAndGet();
        }
    }
    public static void main(String[] args) {
        AtomicIntegerMonitor atomicIntegerMonitor = new AtomicIntegerMonitor();
        atomicIntegerMonitor.inc();
        AtomicInteger ai = new AtomicInteger(5);
        ai.incrementAndGet();
        ai.incrementAndGet();
        ai.incrementAndGet();
        ai.decrementAndGet();

        System.out.println(ai);
        int andIncrement = ai.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(ai.getAndDecrement());
        System.out.println(ai.intValue());
        System.out.println(ai.getAndAdd(5));

        System.out.println("*****************");
        AtomicInteger x = new AtomicInteger(10);//初始化赋值x=10
        System.out.println(x.incrementAndGet());//原子上增加一个当前值。x=x+1;x=10+1
        System.out.println(x.get());//获取当前值 x=11
        x.set(20);//设置给定值  x=20;
        System.out.println(x);//20
        System.out.println(x.decrementAndGet());//原子减1当前值。 --x=19
        System.out.println(x.decrementAndGet());//原子减1当前值。 --x=18
        System.out.println(x.getAndIncrement());//原子减1当前值。x-1=19
        System.out.println(x.getAndIncrement());//x-1=19
        System.out.println(x.get());//获取当前值
        System.out.println(x.incrementAndGet());
        System.out.println(x.get());//获取当前值
        System.out.println(x.addAndGet(20));//将给定的值原子地添加到当前值。类似x=x+20
        System.out.println(x.compareAndSet(41,42));//如果当前值 ==为预期值expect，则将该值原子设置为给定的更新值
        System.out.println(x.weakCompareAndSet(42,42));//如果当前值 ==为预期值，则将值设置为给定更新值。

        System.out.println(x);//当前原子值42
        System.out.println(x.addAndGet(20));//62    将给定的值20原子地添加到当前值+20。
        System.out.println(x.getAndSet(20));//62 将原子设置为给定值并返回旧值。
        System.out.println(x);//当前值变为20
        System.out.println(x.intValue());//将 AtomicInteger的值作为 int 。
        System.out.println(x.toString());//返回当前值的String表示形式。

        System.out.println("-----------------------------------");
        AtomicInteger integer = new AtomicInteger(100);//初始值为100,当前值为100
        System.out.println(integer.getAndIncrement());//当前值int类型。然后自增i++; 100
        System.out.println(integer);//101
        System.out.println(integer.getAndIncrement());//101 当前值102
        System.out.println(integer.getAndIncrement());//102 当前值103
        System.out.println(integer.incrementAndGet());//直接自增后返回 ++i。104 当前值104
        //自减方法x--.x=x-1
        System.out.println("当前值："+integer);
        System.out.println(integer.decrementAndGet());//--i 103 当前值103
        System.out.println(integer.decrementAndGet());// --i 102 当前值102
        System.out.println(integer.getAndDecrement());//i--  102 当前值101
        System.out.println(integer.getAndDecrement());//i--  101 当前值100
        System.out.println(integer);
        System.out.println("***************************");
        //原子性更新值compareAndSet和weakCompareAndSet
        System.out.println("原子性更新值:当前值"+integer);
        System.out.println(integer.compareAndSet(100,200));//当前值100，预期值expect 如果当前值 ==为预期值，则将该值原子设置为给定的更新值和比较当前值和设置,把值更新为当前值
        System.out.println(integer.compareAndSet(100,200));//比较当前值和设置,把值更新为当前值
        System.out.println("更新后的当前值："+integer);
        System.out.println(integer.weakCompareAndSet(200,250));//和compareAndSet一样，底层CAS：compxchg
        System.out.println("更新后的当前值："+integer);
        //将给定的值原子地添加到当前值。 原子性的更新 现在的值（当前值）=旧的当前值+更新值  ，自旋+CAS算法实现
        System.out.println(integer.getAndAdd(50));//返回值（旧的当前值）250 当前值300
        System.out.println("更新后的当前值："+integer);//当前值=旧的250+50
        System.out.println(integer.addAndGet(50));//返回值350=300+50，当前值350=300+50
        //函数式的接口1.8新增的
      //  System.out.println(integer.getAndUpdate(integer->integer+50)==350);





    }
}

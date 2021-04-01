package com.lichuandi.concurrent.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Threads(5)//设置五个线程基准测试方法
public class JMHExample06
{
    @State(Scope.Thread)//5个运行线程每一个线程都会持有一个Test实例
    public static class Test
    {
        public Test()
        {
            System.out.println("create instance");
        }

        public void method()
        {

        }
    }

    @Benchmark//基准测试引入test
    public void test(Test test)
    {
        test.method();
    }

    public static void main(String[] args) throws RunnerException
    {
        final Options opts = new OptionsBuilder()
                .include(JMHExample06.class.getSimpleName())
                .build();
        new Runner(opts).run();
    }
}
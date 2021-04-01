package com.lichuandi.concurrent.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
public class JMHExample04
{
    //平均响应时间 elapsed/operation
    @BenchmarkMode(Mode.AverageTime)
    @Benchmark
    public void testAverageTime() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }
    //方法吞吐量 与AverageTime相反，单位时间内可以对该方法调用多少次
    @BenchmarkMode(Mode.Throughput)
    @Benchmark
    public void testThroughput() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    //时间采样 抽样方式直观图
    @BenchmarkMode(Mode.SampleTime)
    @Benchmark
    public void testSampleTime() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.SingleShotTime)//进行冷测试每一次批次基准测试只会执行一次一般情况下warmup设置位0
    @Benchmark
    public void testSingleShotTime() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    @BenchmarkMode({Mode.AverageTime, Mode.Throughput})
    @Benchmark
    public void testThroughputAndAverageTime() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    @BenchmarkMode(Mode.All)
    @Benchmark
    public void testAll() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    public static void main(String[] args) throws RunnerException
    {
        final Options opts = new OptionsBuilder()
                .include(JMHExample04.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opts).run();
    }
}
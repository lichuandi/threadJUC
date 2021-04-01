package com.lichuandi.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @Auther digege
 * 统计单词类
 * hello word
 * hello word
 * bye hadoop
 *
 * ----
 * bye 1
 * hadoop 2
 * hello 2
 * world 1
 *
 * @Date 2021/1/18
 * @Description：com.lichuandi.hadoop version：1
 */
public class WordCount {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //初始化Configuration
        Configuration conf = new Configuration();
        //通过实例化对象GenericOptionsParser可以获得程序执行所传入的参数
        String[] otherArgs = new GenericOptionsParser(conf,args).getRemainingArgs();
        if(otherArgs.length<2){
            System.err.println("Usage: worldcount <in> [<in>...] <out>");;
            System.exit(2);
            //构建任务对象
            Job job = Job.getInstance(conf, "world count");
            job.setJarByClass(WordCount.class);
            job.setMapperClass(WordCounts.TokenizerMapper.class);
            job.setCombinerClass(WordCounts.IntSumReducer.class);
            //设置输出
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            for (int i=0;i<otherArgs.length-1;i++){
                //设置需要统计的路径文件输入的路径
                FileInputFormat.addInputPath(job,new Path(otherArgs[i]));
            }
            //设置统计结果的输出路径
         //   FileOutputFormat.setOutputPath(job.new Path(otherArgs[(otherArgs.length -1)]));
            FileOutputFormat.setOutputPath(job,new Path(otherArgs[(otherArgs.length -1)]));
            //提交任务给Hadoop集群
            System.exit(job.waitForCompletion(true)? 0:1);
        }

    }
    //自定义内部类Reduce
    public static class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
        //IntWritable相当于Integer
        private  IntWritable result=new IntWritable();
        //输入key，输入value，输出key，输出value类型 和map方法的参数匹配
        public  void  reduce(Text key,Iterable<IntWritable> values,Reducer<Text,IntWritable,Text,IntWritable>.Context context)
                throws  IOException,InterruptedException{
            //统计单词总数
            int sum=0;
            for (IntWritable val:values
            ) {
                sum+=val.get();
            }
            this.result.set(sum);
            //统计输出结果
            context.write(key,this.result);
        }
    }
    //自定义Mapper内部类
    public static class  TokenizerMapper extends Mapper<Object,Text,Text,IntWritable>{
        public static final IntWritable one=new IntWritable(1);
        private Text word=new Text();
         //输入key，输入value，输出key，输出value类型
        public  void  map(Object key,Text value,Mapper<Object,Text,Text,IntWritable>.Context context)
                throws  IOException,InterruptedException{
            //默认根据空格。制表符\t。换行符\n，回车符\r分割字符串
            StringTokenizer itr=new StringTokenizer(value.toString());
            //循环输出每个单词与数量
            while (itr.hasMoreTokens()){
                this.word.set(itr.nextToken());
                //输出单词与数量
                context.write(this.word,one);
            }
        }
    }
}

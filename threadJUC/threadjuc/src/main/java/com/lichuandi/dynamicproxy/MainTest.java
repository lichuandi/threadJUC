package com.lichuandi.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * @author digege
 * @date 2021/9/3 14:59
 * @description：动态代理例子
 * @page com.lichuandi.dynamicproxy version：1
 */
public class MainTest {
  public static void main(String[] args) {
    // 使用实现接口,父类类型.里氏原则
    DyProxy lichuandi = new HelloLichuandi();
    lichuandi.hello("lichuandi");

    CharSequence cs = new StringBuilder();
    System.out.println(cs.toString());
    // 使用代理 先定义接口，不写实现类，后使用jdk来代理调用接口的对象
    InvocationHandler handler =
        (proxy, method, obj) -> {
          System.out.println(method);
          System.out.println(method.getName());
          // 方法是名称 接口的方法名称调用
          String methodName = "hello";
          if (methodName.equals(method.getName())) {
            System.out.println("Good morning:" + obj[0]);
          }
          return null;
        };
    // 使用代理对象Proxy创建对象,传入规定的参数
    /*  Object o = Proxy.newProxyInstance();*/
    DyProxy dyProxy =
        (DyProxy)
            newProxyInstance(
                // Classloader对象
                DyProxy.class.getClassLoader(),
                // 实现的接口数组
                new Class[] {DyProxy.class},
                // 处理调用的方法InvocationHandler
                handler);
    // 使用动态代理调用
    dyProxy.hello("digege");
  }
  /**
   * 在运行期动态创建一个interface实例的方法如下：
   *
   * <p>定义一个InvocationHandler实例，它负责实现接口的方法调用； 通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
   * 使用的ClassLoader，通常就是接口类的ClassLoader； 需要实现的接口数组，至少需要传入一个接口进去； 用来处理接口方法调用的InvocationHandler实例。
   * 将返回的Object强制转型为接口。 动态代理实际上是JVM在运行期动态创建class字节码并加载的过程，它并没有什么黑魔法，把上面的动态代理改写为静态实现类大概长这样：
   *
   * <p>public class HelloDynamicProxy implements Hello { InvocationHandler handler; public
   * HelloDynamicProxy(InvocationHandler handler) { this.handler = handler; } public void
   * morning(String name) { handler.invoke( this, Hello.class.getMethod("morning", String.class),
   * new Object[] { name }); } } 其实就是JVM帮我们自动编写了一个上述类（不需要源码，可以直接生成字节码），并不存在可以直接实例化接口的黑魔法。
   */
}

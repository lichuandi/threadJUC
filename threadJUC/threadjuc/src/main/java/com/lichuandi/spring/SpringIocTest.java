package com.lichuandi.spring;

/**
 * @Auther digege
 * @Date 2021/4/26
 * @Description：com.lichuandi.spring version：1
 */
public class SpringIocTest {
    public static void main(String[] args) throws Exception {

        //加载配置文件
        BeanFactory f = new ClassPathXmlApplicationContext("beans/bean/applicationContext.xml");

        Object os = f.getBean("dog");
        Animal dog = (Animal)os;
        dog.say();

        Object op = f.getBean("chicken");
        Animal chicken = (Animal)op;
        chicken.say();

        Object p = f.getBean("people");
        People people= (People) p;
        people.info();
    }
}

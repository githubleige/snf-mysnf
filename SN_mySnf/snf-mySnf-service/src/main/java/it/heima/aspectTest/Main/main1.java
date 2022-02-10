package it.heima.aspectTest.Main;

import it.heima.aspectTest.bean.HelloApi;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main1 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:/conf/aspectXml/aspectTest.xml");
        HelloApi helloapi1 = beanFactory.getBean("helloapi1",HelloApi.class);
//        int str=helloapi1.aspectTest("a", "b");
//        System.out.println(str);
//        helloapi1.aspectTest1("a", "b");
        helloapi1.aspectTest("a", "b");
    }

}

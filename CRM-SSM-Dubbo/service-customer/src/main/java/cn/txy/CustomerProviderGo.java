package cn.txy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CustomerProviderGo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("容器初始化...");
        context.start();
        System.out.println("customerProvider已就绪, 监听端口是20880, 等待web_app调用..");
        System.in.read();
    }
}

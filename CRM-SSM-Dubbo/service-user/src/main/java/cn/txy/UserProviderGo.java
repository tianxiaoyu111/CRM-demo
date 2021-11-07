package cn.txy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class UserProviderGo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("容器初始化...");
        context.start();
        System.out.println("UserProvider已就绪, 监听端口是20881, 等待web_App调用..");
        System.in.read();
    }
}

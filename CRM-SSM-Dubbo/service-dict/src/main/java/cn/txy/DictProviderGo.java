package cn.txy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DictProviderGo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("容器初始化...");
        context.start();
        System.out.println("dictProvider已就绪, 监听端口是20882, 等待web_app调用..");
        System.in.read();
    }
}

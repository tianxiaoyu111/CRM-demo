package cn.txy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot启动入口类的注解
@SpringBootApplication
public class WebAppGo {
    public static void main(String[] args) {
        //指定从当前类开始运行
        SpringApplication.run(WebAppGo.class, args);
    }
}

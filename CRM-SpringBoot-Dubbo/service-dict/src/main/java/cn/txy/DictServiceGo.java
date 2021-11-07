package cn.txy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot启动入口类的注解
@SpringBootApplication
@MapperScan("cn.txy.dao")
@EnableDubbo
public class DictServiceGo {
    public static void main(String[] args) {
        //指定从当前类开始运行
        SpringApplication.run(DictServiceGo.class, args);
    }
}

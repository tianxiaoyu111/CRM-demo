package cn.txy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerGo {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerGo.class, args);
    }
}

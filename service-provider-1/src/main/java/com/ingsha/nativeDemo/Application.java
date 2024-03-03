package com.ingsha.nativeDemo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName Application
 * @Description TODO
 * @Author Martin Yi
 * @Date 2024/3/2 20:41
 * @Version 1.0
 */

@SpringBootApplication
@EnableDubbo
public class Application {

    public static void main(String[] args) {
//        System.setProperty("native", "true");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("启动成功");
    }

}

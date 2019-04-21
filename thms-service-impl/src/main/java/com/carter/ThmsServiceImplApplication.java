package com.carter;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
public class ThmsServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThmsServiceImplApplication.class, args);
    }

}

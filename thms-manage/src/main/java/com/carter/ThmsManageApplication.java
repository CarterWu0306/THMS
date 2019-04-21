package com.carter;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class ThmsManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThmsManageApplication.class, args);
    }

}

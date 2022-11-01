package com.higher.scancodescollect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.higher.scancodescollect.dao")
public class ScanCodesCollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScanCodesCollectApplication.class, args);
    }

}

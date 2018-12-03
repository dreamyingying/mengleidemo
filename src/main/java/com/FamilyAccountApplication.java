package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.menglei.family.account")
@MapperScan("com.menglei.family.account.dao")
@ServletComponentScan("com.menglei.family.account")
public class FamilyAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyAccountApplication.class, args);
    }
}

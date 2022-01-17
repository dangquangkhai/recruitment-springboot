package com.dev.recruitmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RecruitmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentSystemApplication.class, args);
    }

}

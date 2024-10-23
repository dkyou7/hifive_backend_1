package com.example.hifive_be_1;

import com.example.hifive_be_1.api_v1.member.Member;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HifiveBe1Application {
    public static void main(String[] args) {
        SpringApplication.run(HifiveBe1Application.class, args);
    }
}

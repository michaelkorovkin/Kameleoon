package com.kameleoon.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class TestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }

}

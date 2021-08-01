package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      //항상 상단에 위치. 스프링 부트의 자동 설정, 스프링 bean 읽기와 생성 모두 자동으로 설정됨.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}   //SpringApplication으로 인해 내장 WAS를 실행함.

package com.in28minutes.learn_spring_framework.example.a0;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleSpringContextLauncherApp {

    /*
     * 의존성의 주입 종류 :
     * 1. 생성자 주입
     * 2. setter 주입
     * 3. 필드 주입
     */

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApp.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

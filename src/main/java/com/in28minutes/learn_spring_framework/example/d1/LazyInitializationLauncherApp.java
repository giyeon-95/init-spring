package com.in28minutes.learn_spring_framework.example.d1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
}

/*
 * @Lazy
 * Spring Bean의 초기화 기본값은 '즉시 초기화'다.
 * @Lazy선언시, 해당 Bean이 사용될 때까지 초기화되지 않는다.
 * 로드시간을 줄이거나, 메모리를 절약시 사용될 수 있다. 
 * (하지만, APP이 실행될때 오류를 바로 확인할 수 있으므로 '즉시초기화'가 추천된다. (@Lazy는 테스트용도로 사용))
 */
@Component
@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some init logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Doing something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApp.class)) {

            System.out.println("Main Initialization done");

            /* Main에서 ClassB Bean을 사용하면, Lazy로 설정된 ClassB Bean이 초기화가 진행된다. */
            context.getBean(ClassB.class).doSomething();;
        }
    }

}

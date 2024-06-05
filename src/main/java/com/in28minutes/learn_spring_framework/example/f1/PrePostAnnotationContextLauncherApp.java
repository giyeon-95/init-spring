package com.in28minutes.learn_spring_framework.example.f1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Dependency Ready");
    }
}

@Component
class SomeClass {
    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;

        System.out.println("Dependency Injection done");
    }

    /*
     * @PostConstruct : 의존성 설정 이후(생성자 호출 이후) 바로 실행.
     */
    @PostConstruct
    public void onInit() {
        someDependency.getReady();
    }

    /* @PreDestroy : context에서 Bean이 삭제될시 실행 */
    @PreDestroy
    public void onDestroy() {
        System.out.println("Destroying Bean");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApp.class)) {

            System.out.println("Main Initialization done");
        }
    }
}

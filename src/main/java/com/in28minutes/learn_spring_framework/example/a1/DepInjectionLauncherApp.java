package com.in28minutes.learn_spring_framework.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessClass {

    /*
     * 생성자 의존성 주입 : @Autowired로 @Component 의존성 추가 가능. (spring 추천 의존성 주입 방법)
     */

    Dependency1 dependency1;
    Dependency2 dependency2;

    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /*
     * Setter 의존성 주입
     * Dependency1 dependency1;
     * Dependency2 dependency2;
     * 
     * @Autowired
     * public void setDependency1(Dependency1 dependency1) {
     * System.out.println("Setter injection -1");
     * this.dependency1 = dependency1;
     * }
     * 
     * @Autowired
     * public void setDependency2(Dependency2 dependency2) {
     * System.out.println("Setter injection -2");
     * this.dependency2 = dependency2;
     * }
     */

    /*
     * 필드 의존성 주입 : @Autowired로 @Component 의존성 추가 가능.
     * 
     * @Autowired
     * Dependency1 dependency1;
     * 
     * @Autowired
     * Dependency2 dependency2;
     */

    public String toString() {
        return "BusinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApp {

    /*
     * 의존성의 주입 종류 :
     * 1. 생성자 주입
     * 2. setter 주입
     * 3. 필드 주입
     */

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApp.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessClass.class));

        }
    }
}

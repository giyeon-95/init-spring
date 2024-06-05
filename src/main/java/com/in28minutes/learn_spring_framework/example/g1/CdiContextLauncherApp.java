package com.in28minutes.learn_spring_framework.example.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/* 
 * CDI 어노테이션 (@Named / @Inject)을 사용한 의존성 주입 방법 
 * (주석 처리부분은 Setter를 통한 주입 방식 : Setter 방식에서 jakarta 어노테이션으로 변경됨.)
 * @Named : @Component 대체
 * @Inject : @Autowired 대체
 * (pom.xml에서 jakarta.inject:jakarta.inject-api:1.0.1 의존성 추가 필요)
 */

// @Component
@Named
class BussinessService {

    private DataService dataService;

    /* @Autowired : Setter 주입 방식 */
    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }
}

// @Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApp.class)) {

            System.out.println("Main Initialization done");

            System.out.println(context.getBean(BussinessService.class).getDataService());
        }
    }
}

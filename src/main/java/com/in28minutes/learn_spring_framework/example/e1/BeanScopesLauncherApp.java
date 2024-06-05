package com.in28minutes.learn_spring_framework.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* 싱글톤 : 
 * Spring에서 생성되는 모든 Bean은 싱클톤. (Bean을 호출할 때마다 동일한 인스턴스 반환)
 * Spring loC 컨테이너당 객체 인스턴스가 단 하나만 생성되어 사용된다.
 * 99.9% 의 Spring Bean 대부분은 싱글톤을 사용한다.
 * (세션 스코프의 경우 HTTP 세션당 객체 인스턴스가 단 하나만 생성되어 사용된다.)
 */
@Component
class NormalClass {

}

/*
 * 프로토타입 :
 * 
 * @Scope로 Scope를 ProtoType 지정가능.
 * (리퀘스트 스코프의 경우 HTTP 요청마다 새로운 인스턴스 생성.)
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ProtoTypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApp.class)) {

            System.out.println("Main Initialization done");

            /* 프로토타입이 아닌 Normal Bean은 여러번 호출되어도 동일한 인스턴스가 호출됨. */
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            /* SCOPE_PROTOTYPE 으로 지정된 Bean은 호출시마다 새로운 인스턴스 생성. */
            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));
        }
    }
}

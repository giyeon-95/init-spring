package com.in28minutes.learn_spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        /*
         * 1. JVM 내에 Spring context(spring container) 생성 : spring이 객체들을 미리 생성하여 관리하는 공간을
         * spring container라고 한다.
         * Spring Container(IOC Container & Spring context)는 bean의 생성과 소멸, 생명주기를 관리한다.
         * Spring Container은 1. BeanFactory (기본 Spring container) 2. ApplicationContext
         * (엔터프라이즈 전용 기능이 있느 고급 컨테이너 & 자주 사용되는 컨테이너)
         * 로 구분된다.
         */

        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            /*
             * 2. context 내에 정의되어 있는 Bean호출 : getBean()을 통해 context내에 정의되어 있는 Bean을 가져올 수
             * 있다. (실제 APP에서는 거의 사용되지 않는다.)
             */
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person")); // Ravi, 20

            System.out.println(context.getBean("person2MethodCall")); // Renga, 15

            System.out.println(context.getBean("person3Params")); // Renga, 15

            System.out.println(context.getBean("person5Qualifier")); // Address : "Baker Street3", "London3"

            System.out.println(context.getBean("address2"));

            /* Bean의 타입을 이용하여 가져오는 것도 가능하다. */
            System.out.println(context.getBean(Address.class));

            /*
             * 아래처럼 호출은 불가능하다. ( person, person2MethodCall, person3Params 세 가지가 있기때문에 특정
             * 불가능.
             * 특정 Bean에 @Primary 설정시 해결 가능)
             */
            System.out.println(context.getBean(Person.class));

            /* 정의되어 있는 Bean 내역 호출 */
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}

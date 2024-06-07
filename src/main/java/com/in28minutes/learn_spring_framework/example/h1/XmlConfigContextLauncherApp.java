package com.in28minutes.learn_spring_framework.example.h1;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;

public class XmlConfigContextLauncherApp {

    /*
     * /resources/contextConfig.xml 파일을 이용한 설정 방법
     * XML형식으로 Spring Bean을 정의할 수 있다.
     * (XML형식으로는 자주 사용되지 않는다.)
     */

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("contextConfig.xml")) {

            System.out.println("Main Initialization done");
 
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            // System.out.println(context.getBean("game"));

            // System.out.println(context.getBean("gameRunner"));

            context.getBean(GameRunner.class).run();
        }
    }
}

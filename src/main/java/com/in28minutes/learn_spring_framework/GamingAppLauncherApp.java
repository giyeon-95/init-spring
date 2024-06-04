package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GamingAppLauncherApp {

    /* 다중 @Component class 발생시, @Primary 우선 Scan. */

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApp.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}

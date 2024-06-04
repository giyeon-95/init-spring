package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GamingAppLauncherApp {


    /* Bean 자동생성 ( pacmanGame instance / GameRunner instance 자동생성 ) 
     * 아래 Bean을 제거하고, PacmanGame Class / GameRunner Class에 @Component를 설정한다.
     * PacmanGame Class / GameRunner Class 가 위치하는 경로를 ComponentScan에 추가한다.
     * 이로써 Spring은 자동으로 패키지를 스캔하고, 컴포넌트를 찾고, 인스턴스를 생성하고, 의존성을 주입한다.
    */

    // @Bean
    // public GamingConsole game() {
    //     var game = new PacmanGame();
    //     return game;
    // }

    // @Bean
    // public GameRunner gameRunner(GamingConsole game) {
    //     var gameRunner = new GameRunner(game);
    //     return gameRunner;
    // }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApp.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}

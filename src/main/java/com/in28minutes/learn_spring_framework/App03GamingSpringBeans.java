package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.Bean;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App03GamingSpringBeans {

    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}

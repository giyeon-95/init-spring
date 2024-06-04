package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;

    /* @Qualifier class 가 있는경우, @Qualifier로 class를 특정할 수 있다. */
    // public GameRunner(@Qualifier("superContraQualifier") GamingConsole game) {
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running the game: " + game);

        game.up();
        game.down();
        game.left();
        game.right();
    }
}

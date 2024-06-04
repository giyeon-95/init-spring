package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {


        // 1. Objecrt Creation
        // var game = new MarioGame();
        // var game = new SuperContraGame();
        var game = new PacmanGame();

        // 2. Object Creation & set Dependencies : GameRunner는 game에 의존한다.
        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}

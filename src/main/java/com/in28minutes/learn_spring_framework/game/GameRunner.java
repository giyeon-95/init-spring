package com.in28minutes.learn_spring_framework.game;

public class GameRunner {

    /*
     * 결합의 정도 *
     * 
     * 느슨한 결합 -> GameRunner 클래스가 어떠한 game 클래스를 사용할 때, 별도의 인스턴스를 생성하지 않고 생성자를 통해
     * 전달받는다. (GameRunner 클래스 생성자만 수정필요)
     * 강한 결합 -> GameRunner 클래스가 어떠한 game 클래스를 사용할 때, 클래스의 인스턴스를 추가적으로 생성한다.
     * (GameRunner 클래스 생성자와 run 메소드 수정필요)
     */

    // private MarioGame game;
    private SuperContraGame game;

    public GameRunner(SuperContraGame game) {
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

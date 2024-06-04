package com.in28minutes.learn_spring_framework.game;

/* interface : 
 * 특정 class들의 공통 로직 수행.
 * interface 를 implements 하는 class 들은 아래 정의된 메소드들을 반드시 구현해야 한다.
 */
public interface GamingConsole {

    void up();

    void down();

    void left();

    void right();
}

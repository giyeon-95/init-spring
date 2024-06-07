package com.in28minutes.learn_spring_framework.example.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/* 
 * @Component는 다양하게 나뉜다.
 * @Service : 비즈니스 로직을 처리하는 클래스에 사용 
 * @Controller : 웹 컨트롤러 등 컨트롤러 클래스에 사용
 * @Repository : DB처리 클래스에 사용
 * 
 * 각 class의 역할에 맞게 어노테이션을 주는 것이 좋다.
 */

/* 
 * Repository class에서 DB 처리 수행.
 */

@Repository
@Primary
public class MongoDbDataService {

    public int[] retrirveAllData() {
        return new int[] { 5, 89, 100 };
    }
}

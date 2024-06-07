package com.in28minutes.learn_spring_framework.example.c1;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDataService {
    public int[] retrirveAllData() {
        return new int[] { 5, 89, 100 };
    }
}

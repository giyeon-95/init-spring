package com.in28minutes.learn_spring_framework.example.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
class BussinessService {

    private DataService dataService;

    /* @Autowired : Setter 주입 방식 */
    @Autowired
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApp.class)) {

            System.out.println("Main Initialization done");

            System.out.println(context.getBean(BussinessService.class).getDataService());
        }
    }
}

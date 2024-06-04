package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/* record 사용시 getter, setter, 생성자 자동생성. */
record Person(String name, int age, Address address) {
}

record Address(String firstLine, String city) {
}

@Configuration
public class HelloWorldConfiguration {
    /*
     * Spring에서 관리하는 자바 객체를 Bean이라고 하며,
     * 해당 클래스에서 @Bean 어노테이션을 사용하여 메서드를 생성하여 Spring Bean을 정의할 수 있다.
     */

    @Bean
    public String name() {
        return "Renga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        var person = new Person("Ravi", 20, new Address("Main Street", "New York"));

        /* record 사용시 아래와 같이 사용 가능. */
        // person.age();
        // person.name();

        return person;
    }

    @Bean
    public Person person2MethodCall() {
        // 정의되어 있는 Bean 사용 가능.
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Params(String name, int age, Address address2) {
        /* person3Params Bean 호출시, person3Params param에는 정의되어 있는 Bean들이 들어가게 된다. */
        return new Person(name, age, address2);
    }

    @Bean
    @Primary
    public Person person4Params(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    /* Qualifier로 설정된 Bean이 있다면, param에 Qualifier로 특정 Bean 설정이 가능 */
    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {
        return new Person(name, age, address);
    }

    /*
     * name을 address2로 설정한 경우, address로 호출은 불가능.
     * 
     * @Primary 설정으로 Bean을 호출할 경우 우선순위를 정할 수 있다.
     */
    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Baker Street", "London");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("Baker Street3", "London3");
    }
}

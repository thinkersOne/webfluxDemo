package org.example.functional.endpoints.handler;

import org.example.functional.endpoints.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhihao
 * @data 2021/1/17
 * @time 11:42
 */
@Component
public class PersonHandler {

    public Mono<ServerResponse> listPeople(ServerRequest request) {
        long startTime = System.currentTimeMillis();
        System.out.println("执行 listPeople 方法。。");
        List<Person> personList = new ArrayList<>(10);
        for (int i = 0; i < 100000; i++) {
            Person person = new Person();
            person.setId(Long.valueOf(i+1));
            person.setAge(i+10);
            person.setName("zhangsan"+i);
            person.setSex("M");
            person.setAddress("湖北");
            personList.add(person);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("列表查询共耗时:"+ (endTime - startTime) + "毫秒");
        return ServerResponse.ok().body(Mono.just(personList),List.class);
    }

    public Mono<ServerResponse> createPerson(ServerRequest request) {
        System.out.println("执行 createPerson 方法。。");
        return ServerResponse.ok().body(Mono.just(1),Integer.class);
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        System.out.println("执行 getPerson 方法。。");
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setSex("M");
        person.setAddress("湖北");
        person.setAge(20);
        return ServerResponse.ok().body(Mono.just(person),Person.class);
    }

}

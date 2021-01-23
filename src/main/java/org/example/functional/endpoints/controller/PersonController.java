package org.example.functional.endpoints.controller;

import org.example.functional.endpoints.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhihao
 * @data 2021/1/17
 * @time 12:01
 */
@RestController
public class PersonController {

    @GetMapping("list")
    public List<Person> list(){
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
        return personList;
    }

}

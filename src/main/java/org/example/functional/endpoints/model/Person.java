package org.example.functional.endpoints.model;

import lombok.Data;

/**
 * @author lizhihao
 * @data 2021/1/17
 * @time 11:45
 */
@Data
public class Person {
    private Long id;
    private String name;
    private int age;
    private String sex;
    private String address;

}

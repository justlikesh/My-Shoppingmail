package com.apple8._shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Homework {
    private String name = "승호";
    private Integer age = 1;

    public Integer 한살더하기(){
        this.age += 1;
        return age;
    }

    public void 나이설정(Integer age){
        if(age<=100 && 0<=age){
            this.age = age;
        }
    }

}

package com.apple8._shop;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class NameAndAge {
    private String name;
    private Integer age;

    public void plusAge(){
        age = age + 1;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if( 0 <= age && age < 100) {
            this.age = age;
        }
    }
}

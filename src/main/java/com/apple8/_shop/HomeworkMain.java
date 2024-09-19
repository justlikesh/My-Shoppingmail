package com.apple8._shop;


public class HomeworkMain {
    public static void main(String[] args) {
        var object = new Homework();
        object.setAge(23);
        object.나이설정(-1);
        object.한살더하기();
        object.setName("용혁");

        System.out.println(object);
    }
}

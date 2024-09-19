package com.apple8._shop;

public class NameAndAgeMain {
    public static void main(String[] args){
        var a = new NameAndAge();
        a.setAge(99);
        a.plusAge();

        System.out.println(a.getAge());
    }
}

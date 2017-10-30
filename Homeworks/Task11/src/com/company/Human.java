package com.company;

public class Human implements Comparable<Human> {

    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "[" + name + " " + age + "]";
    }


    @Override
    public int compareTo(Human that) {
        return this.age - that.age;
    }

}
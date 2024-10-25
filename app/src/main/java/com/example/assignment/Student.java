package com.example.assignment;

public class Student {
    private String name;
    private double age;
    private String id;
    private double mark;

    public Student(String name, double age, String id, double mark) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + id + "," + mark ;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

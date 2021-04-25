package com.gxz.autodev.config;

import java.io.Serializable;

public class Person implements Serializable {

    private  String uuid;
    private  String name;
    private  Integer age;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

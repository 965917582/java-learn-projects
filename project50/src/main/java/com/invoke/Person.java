package com.invoke;

import java.math.BigDecimal;

public class Person {
    private int id;
    public String name;
    int age;
    protected BigDecimal account;
    public Person(){}
    public Person(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void eat(String name){
        System.out.println(name+"喜欢铁锅炖大鹅");
    }
    public void introduction(Person person){
        System.out.println(person.getName()+"，编号为"+person.getId()+",今年"+person.getAge()+"岁，他喜欢吃青阳炒鸡。");
    }
    public int howold(int age){
        return age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public BigDecimal getAccount() {
        return account;
    }
    public void setAccount(BigDecimal account) {
        this.account = account;
    }
}

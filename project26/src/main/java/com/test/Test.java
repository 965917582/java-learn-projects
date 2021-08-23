package com.test;

import com.alibaba.fastjson.JSON;
import com.pojo.Person;
import com.pojo.Student;
import com.pojo.Teacher;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setGrade(1);
        student.setName("lisi");
        Student student1 = new Student();
        student1.setName("zs");
        student1.setGrade(11);
        Teacher teacher = new Teacher();
        teacher.setClass_id(12);
        teacher.setName("marry");
        ArrayList<Student> objects = new ArrayList<>();
        objects.add(student);
        objects.add(student1);
        teacher.setList(objects);
        Person person = new Person();
        person.setCountry("china");
        person.setTeacher(teacher);
        String s = JSON.toJSONString(person);
        System.out.println(s);
    }
}

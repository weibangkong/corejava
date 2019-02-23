package com.kwb.day07;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person stu = new Student("old_kwb", "Computer science");
        Person emp = new Employee("future_kwb", 10000d, LocalDate.of(2018, 11, 23));
        Person[] persons = new Person[2];
        persons[0] = stu;
        persons[1] = emp;
        ((Employee) emp).raiseSalary(200);//在使用子类方法时，将类型转换为子类
        for (Person per : persons) {
            System.out.println(per.getDescription());
        }
        Person man = new Manager("kwb",1000d,LocalDate.of(2018, 11, 24),500d);
        System.out.println(emp.toString());
        System.out.println(man.toString());
    }
}

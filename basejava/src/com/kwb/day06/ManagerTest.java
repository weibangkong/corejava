package com.kwb.day06;

import java.time.LocalDate;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("kwb", 1000d, LocalDate.of(2018, 11, 23));
        boss.setBonus(500d);
        System.out.println(boss.getHireDay());
        System.out.println(boss.getName());
        System.out.println(boss.getSalary());
        System.out.println("-------------------------------------------");
        Employee boss2 = new Employee("kwb1", 1000d, LocalDate.of(2018, 11, 23));
        System.out.println(boss2.getHireDay());
        System.out.println(boss2.getName());
        System.out.println(boss2.getSalary());
    }
}

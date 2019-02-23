package com.kwb.day11;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Hobby hobby1 = new Hobby(true, true, true, true, "dance");
        Employee original = new Employee("kwb", 1000, new GregorianCalendar(2018, 11 - 1, 29).getTime(),hobby1);
        Employee cloned = original.clone();
        System.out.println("original:"+original);
        System.out.println("cloned:"+cloned);
        System.out.println();

        cloned.setName("kwb2");
        System.out.println("original:"+original.getName());
        System.out.println("cloned:"+cloned.getName());
        System.out.println();

        cloned.raiseSalary(20);
        System.out.println("original:"+original.getSalary());
        System.out.println("cloned:"+cloned.getSalary());
        System.out.println();

        cloned.setHireDay(2018,11,20);
        System.out.println("original:"+original.getHireDay());
        System.out.println("cloned:"+cloned.getHireDay());
        System.out.println();

        System.out.println("----------------------------------------------");
        /**
         * 下面为不对hobby域执行.clone()的影响
         */
        cloned.getHobby().setEat(false);
        cloned.getHobby().setOther("none");
        System.out.println("original:"+original.getHobby());
        System.out.println("cloned:"+cloned.getHobby());
        System.out.println();

        /**
         * 但是如果是重新引用一个对象，则对原来的对象没有影响
         * 如果setHire(Date hireDay) {this.hireDay = hireDay} 一样是新的引用，对原来的对象没有印象,不涉及到原来对象hireday的的引用的值的变化
         */
        Employee cloned2 = original.clone();
        Hobby hobby2 = new Hobby(false, false, false, false, "none");
        cloned2.setHobby(hobby2);
        System.out.println("original:"+original.getHobby());
        System.out.println("cloned2:"+cloned2.getHobby());
    }
}

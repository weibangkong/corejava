package com.kwb.day11;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;
    private Hobby hobby;

    public Employee(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public Employee(String name, double salary, Date hireDay, Hobby hobby) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(int year,int month,int day) {
        Date hireday = new GregorianCalendar(year, month - 1, day).getTime();//获取Date型
        this.hireDay.setTime(hireday.getTime());//获取long型并赋值
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    /**
     * 重写clone()时,需要对是可变对象的域执行.clone()，引用类型同理
     * @return
     * @throws CloneNotSupportedException
     */
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = null;
        try {
            cloned = (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
//        return (Employee) super.clone();//因为Hobby和HireDay两个域的存在，导致该种实现并不适用于该类
    }

    public void raiseSalary(double byPercent) {
        salary += salary *  byPercent / 100;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", hobby=" + hobby +
                '}';
    }
}

package com.kwb.day07;

import java.time.LocalDate;

public class Employee extends Person {
    private double salary;
    protected LocalDate hireDay;//被标注为protected的域可以被子类直接访问

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    protected void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public Employee(String name, double salary, LocalDate hireDay) {
        super(name);
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent) {
        this.salary = this.salary + this.salary * byPercent / 100;
    }

    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}

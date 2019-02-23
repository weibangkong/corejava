package com.kwb.day06;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        this.bonus = 0d;
    }

    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

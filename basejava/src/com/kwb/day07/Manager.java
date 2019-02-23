package com.kwb.day07;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay, double bonus) {
        super(name, salary, hireDay);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getHireDate() {
        return this.hireDay.toString();
    }

    @Override
    public String toString() {
        return super.toString()+"[bonus="+bonus+"]";
    }
}

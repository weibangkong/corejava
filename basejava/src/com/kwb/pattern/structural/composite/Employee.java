package com.kwb.pattern.structural.composite;

/**
 * 叶子节点
 */
public class Employee implements ICompany {
    private String name;
    private String sex;
    private String position;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, String sex, String position, int salary) {
        this.name = name;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "" +
                "名称:'" + name + '\'' +
                ", 性别'" + sex + '\'' +
                ", 职位'" + position + '\'' +
                ", 薪资" + salary;
    }

}

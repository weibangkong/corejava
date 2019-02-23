package com.kwb.pattern.structural.composite;

import java.util.ArrayList;

/**
 * 树枝节点
 */
public class ConcreteCommpany implements ICompany {
    private ArrayList<ICompany> companyList = new ArrayList<ICompany>();

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

    public ConcreteCommpany(String name, String sex, String position, int salary) {
        this.name = name;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
    }

    public void add(ICompany company) {
        this.companyList.add(company);
    }

    public void remove(ICompany company) {
        this.companyList.remove(company);
    }

    public ArrayList<ICompany> getChild() {
        return this.companyList;
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

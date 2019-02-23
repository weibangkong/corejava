package com.kwb.pattern.structural.composite;

public class Main {
    public static void main(String[] args) {
        ICompany company = new ConcreteCommpany("XXX科技有限公司", "无", "无",0);

        ICompany developer = new ConcreteCommpany("开发","男","研发部经理",0);
        ICompany tester = new ConcreteCommpany("测试","男","测试部经理",0);
        ICompany saler = new ConcreteCommpany("销售","女","销售部经理",0);

        ((ConcreteCommpany) company).add(developer);
        ((ConcreteCommpany) company).add(tester);
        ((ConcreteCommpany) company).add(saler);

        ICompany dev1 = new Employee("开发01","男","软件开发工程师",10000);
        ICompany dev2 = new Employee("开发02","女","软件开发工程师",12000);
        ICompany dev3 = new Employee("开发03","男","软件开发工程师",8000);

        ((ConcreteCommpany) developer).add(dev1);
        ((ConcreteCommpany) developer).add(dev2);
        ((ConcreteCommpany) developer).add(dev3);

        ICompany tester01 = new Employee("测试01","男","软件测试工程师",16000);
        ICompany tester02 = new Employee("测试02","女","软件测试工程师",12000);
        ICompany tester03 = new Employee("测试03","男","软件测试工程师",12000);

        ((ConcreteCommpany) tester).add(tester01);
        ((ConcreteCommpany) tester).add(tester02);
        ((ConcreteCommpany) tester).add(tester03);

        ICompany saler01 = new Employee("销售01","女","销售",16000);
        ICompany saler02 = new Employee("销售02","女","销售",12000);
        ICompany saler03 = new Employee("销售03","女","销售",12000);
        ((ConcreteCommpany) saler).add(saler01);
        ((ConcreteCommpany) saler).add(saler02);
        ((ConcreteCommpany) saler).add(saler03);

        System.out.println(company.getInfo());//解决自我忽略
        display((ConcreteCommpany) company);
    }

    //下面的方法存在自我忽略的问题，因此在main方法中先println了一下自身
    public static void display(ConcreteCommpany company) {
        for (ICompany employee: company.getChild()){
            if (employee instanceof ConcreteCommpany) {//树枝节点
                System.out.println(employee.getInfo());
                display((ConcreteCommpany) employee);
            } else {//叶子节点
                System.out.println(employee.getInfo());
            }
        }
    }
}

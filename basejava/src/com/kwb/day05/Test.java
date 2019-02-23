package com.kwb.day05;

/**
 * java中不存在引用调用，都是值调用
 * 基本类型与引用类型再方法调用时，对域的影响
 * 基本类型不会对原来值产生改变---》是对值的拷贝
 * 引用类型会改变原来的值---》是对一个对象的引用
 */


/**
 * 一个方法不能改变一个基本数据类型的参数(即数值型或布尔型)
 * 一个方法可以改变一个对象参数的状态
 * 一个方法不能让对象参数引用一个新的对象
 */


public class Test {
    public static void main(String[] args) {
//        double percent = 10;
//        triplevalue(percent);
//        System.out.println("main-percent:"+ percent);


//        Employee emp = new Employee("kwb",2000d);
//        System.out.println(emp.getSalary());
//        triplevalue(emp);
//        System.out.println(emp.getSalary());

        Employee emp1 = new Employee("kwb1", 2000d);
        Employee emp2 = new Employee("kwb2", 2500d);
        System.out.println("emp1"+emp1.toString());
        System.out.println("emp2"+emp2.toString());
//        swap(emp1,emp2);
        swap2(emp1,emp2);
        System.out.println("emp1"+emp1.toString());
        System.out.println("emp2"+emp2.toString());
    }

    public static void triplevalue(double x) {
        x = x * 3;
        System.out.println("trip-percent:"+x);
    }
    public static void triplevalue(Employee emp) {
        emp.raiseSalary(200d);
        System.out.println(emp.getSalary());
    }

    /**
     * 该方法因为交换的是两个对象引用的拷贝，在方法执行之后仍是调用方法使用前的引用,对比下面的swap2方法
     * @param emp1
     * @param emp2
     */
    public static void swap(Employee emp1,Employee emp2) {
        Employee temp = emp1;
        emp1 = emp2;
        emp2 = temp;
    }

    public static void swap2(Employee emp1,Employee emp2) {
        Employee temp = new Employee(emp1.getName(),emp1.getSalary());
        temp.setId(emp1.getId());

        emp1.setName(emp2.getName());
        emp1.setSalary(emp2.getSalary());
        emp1.setId(emp2.getId());

        emp2.setName(temp.getName());
        emp2.setSalary(temp.getSalary());
        emp2.setId(temp.getId());
    }
}

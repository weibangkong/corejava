package com.kwb.Tree.Map.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Employee> employees = new HashMap<>();
        employees.put("kwb1", new Employee("2014孔维邦", 20, "男"));
        employees.put("kwb2", new Employee("2015孔维邦", 21, "男"));
        employees.put("kwb3", new Employee("2016孔维邦", 22, "男"));
        employees.put("kwb4", new Employee("2017孔维邦", 23, "男"));
        Set keySet = employees.keySet();
        keySet.forEach(key-> System.out.println(key));

        Collection values = employees.values();
        values.forEach(value -> System.out.println(value));

        Set<Map.Entry<String,Employee>> entrySet = employees.entrySet();
        entrySet.forEach(employee-> System.out.println(employee.getKey()+":"+employee.getValue()));
    }
}

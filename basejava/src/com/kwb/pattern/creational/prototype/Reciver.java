package com.kwb.pattern.creational.prototype;

import java.util.LinkedHashMap;
import java.util.Map;

public class Reciver {
    Map students = new LinkedHashMap();

    public Map getStudents() {
        students.put("张三", "张三@qq.com");
        students.put("李四", "李四@qq.com");
        students.put("王五", "王五@qq.com");
        students.put("马六", "马六@qq.com");
        return students;
    }

    public void setStudents(Map students) {
        this.students = students;
    }
}

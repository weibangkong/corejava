package com.kwb.day09;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if(args.length>0) name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers+" ");
            }
            if (supercl != null && supercl != Object.class) {
                System.out.print("extends "+supercl.getName());
            }
            System.out.print("\n{\n");
            printContructor(cl);
            System.out.println();
            printMethod(cl);
            System.out.println();
            printField(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 获取构造器
     * @param cl
     */
    public static void printContructor(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers+" ");
            }
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 获取方法
     * @param cl
     */
    public static void printMethod(Class cl) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name = method.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(method.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + "");
            System.out.print(retType.getName()+ " "+ name+ "(");
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 获取域
     * @param cl
     */
    public static void printField(Class cl) {
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+ " ");
            System.out.println(type.getName()+ " "+ name +";");
        }
    }
}

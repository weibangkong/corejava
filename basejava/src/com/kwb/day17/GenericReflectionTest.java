package com.kwb.day17;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Collections): ");
            name = in.next();
        }

        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for (Method declaredMethod : cl.getDeclaredMethods()) {
                printMethod(declaredMethod);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl) {
        System.out.println(cl);
        //如果这个类型被声明为泛型类型，则返回泛型类型变量，否则返回长度为0的数组
        printTypes(cl.getTypeParameters(), "<", ",", ">", true);
        //获取被声明为这一类类型的超类的繁星类型，如果这个类型是Object或不是一个类类型，则返回null
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.print(" extends ");
            printType(sc, false);
        }
        //返回被声明为该类型的接口的泛型类型(按照声明次序)，如果这个类型没有接口实现，返回长度为0的数组
        printTypes(cl.getGenericInterfaces(), " implements ", ",", "", false);
        System.out.println();
    }

    public static void printMethod(Method method) {
        String name = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        //如果该方法是泛型方法，则返回泛型类型变量，否则返回长度为0的数组
        printTypes(method.getTypeParameters(), "<", ",", ">", true);
        //获得该方法被声明的泛型返回类型
        printType(method.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        //获得该方法被生命的泛型参数类型，如果该方法没有参数，则返回长度为0的数组
        printTypes(method.getGenericParameterTypes(), "", "", "", false);
        System.out.println();
    }

    public static void printTypes(Type[] types, String pre, String seq, String suf, boolean isDefinition) {
        if(pre.equals(" extends ") && Arrays.equals(types,new Type[] {Object.class})) return;
        if(types.length >0) System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if(i>0) System.out.print(seq);
            printType(types[i], isDefinition);
        }
        if(types.length > 0) System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition) {
                //获取类型变量的子类型限定
                printTypes(t.getBounds()," extends "," & ","",false);
            }
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            //获取通配符子类型限定
            printTypes(t.getUpperBounds()," extends "," & ","",false);
            //获取通配符超类型限定
            printTypes(t.getLowerBounds()," super "," & ","",false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            //如果是内部类型，返回其外部类型，如果是一个顶级类型，则返回null
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            //获取参数化类型的原始类型
            printType(t.getRawType(), false);
            //获取参数化类型声明是所使用的类型参数
            printTypes(t.getActualTypeArguments(),"<",", ",">",false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            //获得声明该数组类型的泛型组建类型
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}

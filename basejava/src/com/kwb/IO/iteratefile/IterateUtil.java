package com.kwb.IO.iteratefile;

import java.io.File;

public class IterateUtil {

    public static void main(String[] args) {
        IterateFile2("d:\\Note",0);
        System.out.println(new File("d:\\Note\\src").isDirectory());
        showDirectory(new File("d:\\Note"));

    }

    public static void IterateFile(String fileName) {
        File file = new File(fileName);
        if (file.isDirectory()) {
            for (File temp_file : file.listFiles()) {
                System.out.println(temp_file);
            }
        }
    }

    public static void IterateFile2(String fileName,int level) {
        File file = new File(fileName);
        if (file.isDirectory()) {//如果是目录
            //先打印文件夹名称
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
            //迭代递归子文件
            for (File temp_file : file.listFiles()) {
                IterateFile2(temp_file.getName(),level+1);
            }
        }else{//如果不是目录
            //打印文件名
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
        }
    }

    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }

    private static void _walkDirectory(File f, int level) {
        if(f.isDirectory()) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
            for(File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        }
        else {
            for(int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }
}

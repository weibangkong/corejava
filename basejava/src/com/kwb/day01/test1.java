package com.kwb.day01;

import java.util.Arrays;

public class test1 {
/*    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        String c = "A";
        String d = "b";
        opera(a, b);
        opera2(c,d);
        System.out.println("a,b:"+a+" , "+b);
        System.out.println("c,d:"+c+" , "+d);
    }*/

/*    public static void main(String[] args) {
        final byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3=(b1+b2);
        System.out.println(b3+b6);
    }*/
public static void main(String[] args) {
    int a = 1;
    int b = 1;
    System.err.println("x++:"+ a++);
    System.err.println("++x:"+ ++b);
    System.out.println("a,b:"+a+","+b);
}
//public static void main(String[] args) {
//    int i = 0;
//    int j = 100;
//    operaINT(i, j);
//    System.out.println("i,j: "+i+" , "+j);
//}

    public static void operaINT(int x, int y) {
//        Math.addExact(x, y);
        x = x + y;
        y = x;
    }

    public static void operaFloat(float x, float y) {
        x = x + y;
        y = x;
    }

    public static void operaSB(StringBuffer x, StringBuffer y) {
//        x.append(y);
        x = x.append(y);
        y = x;
    }

    public static void operaStr(String x, String y) {
        x = x + y;
        y = x;
    }

  /*  public static void main(String[] args) {
        String str = "Im 孔维邦 , Im 这儿 !";
        System.out.println(str.length());    //.length()返回的是UTF-16编码的字符代码单元数量
        System.out.println(str.codePointCount(0,str.length()));//.codePointCount返回的是代码点数，是实际的数量
        //
    }*/
//  public static void main(String[] args) {
//
//      String str = "wo cao ni ma";
////      System.out.println(str.length());
////      System.out.println(str.toLowerCase());
//////      System.out.println(str.toUpperCase());
//      extractdaoguolai(str);
////      System.out.println(str.compareTo("wocao"));
//  }

    private static void extractdaoguolai(String source) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] str_array = source.toCharArray();
        System.out.println(str_array.length);
        for (int i = str_array.length -1; i >= 0; i--) {
            stringBuffer.append(str_array[i]);
        }
        System.out.println(stringBuffer.toString());
    }

    public static void changeValue(int a) {
        a = 1;
    }

//    public static void main(String[] args) {
////        Integer a = 100, b = 100, c = 150, d = 150;
////        System.out.println(a.hashCode());
////        System.out.println(b.hashCode());
////        System.out.println(c.hashCode());
////        System.out.println(d.hashCode());
////        System.out.println(a == b);
////        System.out.println(c == d);
//        System.out.println(Arrays.toString(args));
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s4 = new String("Programming");
//        String s3 = "Program" + "ming";
//        String s6 = "Programming";
//        System.out.println("s1:"+s1.hashCode()+"  ,  s2:"+s1.hashCode());
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s4);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s1.intern());
////        System.out.println(1<<5);
////        int a2 = 100, b2 = 100, c2 = 150, d2 = 150;
////        System.out.println(a == b);
////        System.out.println(c == d);
//    }
//    public static void main(String[] args) {
//        String str1 = "nihao";
//        Integer integer1 = Integer.valueOf(100);
//        System.out.println("Integer:"+integer1.hashCode());
//        System.out.println("String:"+str1.hashCode());
//        str1 = "nihaoa";
//        integer1 = Integer.valueOf(50);
//        System.out.println("Integer:"+integer1.hashCode());
//        System.out.println("String:"+str1.hashCode());
//    }
//    public static void main(String[] args) {
//        int a = 100;
//        System.out.println(a);
//        changeValue(a);
//        System.out.println(a);
//    }
    /**
     * 存在问题，存疑
     */
//    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        System.out.println("please enter what you want to drink");
////        extractdaoguolai(in.nextLine());
//        Console console = System.console();
//        String username = console.readLine("username");
//        char[] passwd = console.readPassword("password");
//    }

}

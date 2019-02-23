package com.kwb.day09;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
//        a = badCopyOf(a, 6);//提示编译报错
        a =(int[]) goodCopyOf(a, 6);
        System.out.println(Arrays.toString(a));

        String[] b = {"kwb", "kwb1", "kwb2"};
        b = (String[]) goodCopyOf(b, 4);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 正确的数组扩容方法，且支持任意格式
     * @param obj
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object obj,int newLength) {
        Class cl = obj.getClass();
        if(!cl.isArray()) return null;
        Class componetType = cl.getComponentType();
        int old_length = Array.getLength(obj);
        Object new_arr = Array.newInstance(componetType, newLength);
        System.arraycopy(obj,0,new_arr,0,Math.min(newLength,old_length));
        return new_arr;
    }

    /**
     * 错误的，应该提示编译错误，问题出现在调用时，原数组不能转换成Object[],而能转换成Object对象
     * @param obj
     * @param newLength
     * @return
     */
    public static Object[] badCopyOf(Object[] obj, int newLength) {
        Object[] new_arr = new Object[newLength];
        System.arraycopy(obj,0,new_arr,0,Math.min(obj.length,newLength));
        return new_arr;
    }

}

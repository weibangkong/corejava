package com.kwb.sort;

public class BuddingSort {

    /**
     * 冒泡排序：
     * 每次比较相邻两个的大小，每一遍过后都会出现一个最大值
     *
     */

    public static void main(String[] args) {
        int[] a = {1,2,45,64,31,82,24};
//        bubbleSort(a);
//        selectSort(a);
        insertSort(a);
    }

    /**
     * 冒泡
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int temp;
        int size = a.length;
        for (int i = 1; i < size -1 ; i++) {
            for (int j = 0; j<size - i ; j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    /**
     * 选择
     * @param a
     */
    public static void selectSort(int[] a) {
        int temp;
        int index;
        int size = a.length;
        for (int i = 0; i < size; i++) {
            index = i;
            for (int j = i+1;j<size;j++){
                if(a[j] < a[index]){
                    index = j;
                }
            }
            if(i != index){
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    /**
     * 快速
     * @param a
     */
    public static void quickSort(int[] a) {
        int temp;
        int size = a.length;
    }

    /**
     * 插入
     * @param a
     */
    public static void insertSort(int[] a) {
        int temp=0;
        int size = a.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

//    if (a[i] < a[i - 1]) {
//        temp= a[i];
//        for (int j = i ; j > 0 && temp<a[j-1]; j--) {
//            a[j+1] = a[j];
//            a[j+1] = temp ;
//        }
//    }
}

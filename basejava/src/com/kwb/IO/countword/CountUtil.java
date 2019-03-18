package com.kwb.IO.countword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountUtil {
    public static void main(String[] args) {
//        int index = 0;
//        String str = "kwb按时的哈拉克斯基和丢弃办的卡不是看火箭";
//        System.out.println((index = str.indexOf("kwb",index+1)));
        countWordInFile2("D:\\tongji.txt","孔维邦");
//        StringBuilder sb = new StringBuilder();
//        sb.append("h");
//        System.out.println(sb.toString());
    }

    /**
     * 下面的方法并不能解决一个单词两行的问题
     * @param fileName
     * @param keyword
     * @return
     */
    public static int countWordInFile(String fileName, String keyword) {
        int counter = 0;
        System.out.println(keyword);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                int index = -1;
                while (line.length() >= keyword.length() && (index = line.indexOf(keyword)) >= 0) {
                    counter++;
                    line = line.substring(index + keyword.length());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static int countWordInFile2(String fileName, String keyword) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String context = sb.toString();
            int index = 0;
            System.out.println(context);
            while (true){//当下标小于内容长度时循环
                //计算出第一次出现的下标并将其赋给index
                index = context.indexOf(keyword, index + 1);
                if (index > 0) {
                    counter++;
                }else{
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}

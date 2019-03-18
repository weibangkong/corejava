package com.kwb.IO.copyfile;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NIOUtil {
    public static void main(String[] args) {
        copyFile("C:\\Users\\WeiBang Kong\\Desktop\\简历.docx","d:\\简历.docx");
    }
    public static void copyFile(String source, String target) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inFic = null;
        FileChannel outFic = null;
        int length = 10000;

        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(target);
            inFic = fis.getChannel();
            outFic = fos.getChannel();
            long startTime = System.currentTimeMillis();
            while (inFic.position() != inFic.size()) {
                if ((inFic.size() - inFic.position()) < length) {
                    length = (int) (inFic.size() - inFic.position());
                }
                inFic.transferTo(inFic.position(), length, outFic);
                inFic.position(inFic.position() + length);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime- startTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outFic.close();
                inFic.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
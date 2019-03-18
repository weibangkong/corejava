package com.kwb.IO.copyfile;

import java.io.*;

public class IOUtil {
    public static void main(String[] args) {
        copyFile1("d:\\iotest1.txt","d:\\iotest2.txt");
//        copy();
    }

    /*--------------------------------------字节流---------------------------------------------*/
    /**
     * 适用于文件较小时
     * @param source
     * @param target
     */
    public static void copyFile1(String source, String target) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int n = 0;
            try {
                fis = new FileInputStream(source);
                fos = new FileOutputStream(target);

                //FileInputStream.read()每次读取1字节的数据，文件大时效率慢
             while ((n = fis.read()) != -1) {
                 fos.write(n);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }finally {
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    fos = null;
                    fis = null;
                }
            }
    }

    /**
     * 10M--30M，更大文件的话会占用较大的空间
     * @param source
     * @param target
     */
    public static void copyFile2(String source, String target) {
        InputStream in = null;
        OutputStream out = null;
        int n = 0;
        byte[] bytes = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            bytes = new byte[in.available()];
            while ((n = in.read(bytes)) != -1) {
                out.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                out = null;
                in = null;
            }
        }
    }

    /**
     * 适用于更大的文件10M左右文件或者视频(1G左右)
     * @param source
     * @param target
     */
    public static void copyFile3(String source, String target) {
        InputStream in = null;
        OutputStream out = null;
        int n = 0;
        byte[] bytes = new byte[1024*1024];
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            while ((n = in.read(bytes)) != -1) {
                out.write(bytes,0,n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                out = null;
                in = null;
            }
        }
    }

    /*-------------------------------------字符流读取---------------------------------------*/

    public void copyFile4(String source, String target) {
        FileReader fr = null;
        FileWriter fw = null;
        int n = 0;
        try {
            fr = new FileReader(source);
            fw = new FileWriter(target);
            while ((n = fr.read()) != -1) {
                fw.write(n);
                System.out.println((char) n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                fw = null;
                fr = null;
            }
        }
    }

    public void copyFile5(String source, String target) {
        FileReader fr = null;
        FileWriter fw = null;
        char[] bs =new char[1024];
        int n = 0;
        try {
            fr = new FileReader(source);
            fw = new FileWriter(target);
            while ((n = fr.read(bs)) != -1) {
                fw.write(bs,0,n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                fw = null;
                fr = null;
            }

        }

    }
}

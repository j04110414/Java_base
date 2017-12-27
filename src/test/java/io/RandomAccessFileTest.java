package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dell on 2017-12-14.
 */
public class RandomAccessFileTest {

    /**
     * 只读文件，偏移读取
     */
    @Test
    public void test() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("d:\\test.txt"), "r");
            System.out.println("文件指针位置：" + raf.getFilePointer());

            raf.seek(100);

            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = raf.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, read));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 给文件结尾添加数据
     */
    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:\\test.txt", "rw");
            raf.seek(raf.length());

            raf.write("\r\n我是一只鱼，水里的鱼游来游去！".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 指定位置写入数据
     */
    @Test
    public void test3() {
        RandomAccessFile raf = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //生成临时文件，在jvm退出时删除
            File tmp = File.createTempFile("tmp", null);
            tmp.deleteOnExit();

            raf = new RandomAccessFile("d:\\test.txt", "rw");

            //使用临时文件保存指定写入点后的数据
            fos = new FileOutputStream(tmp);


            raf.seek(200);

            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = raf.read(bytes)) > 0) {
                //将写入后的数据保存到临时文件
                fos.write(bytes, 0, read);
            }

            //偏移后添加数据
            raf.seek(200);
            raf.write("\r\n******************************************************\r\n".getBytes());

            //写入保存在临时文件的数据
            fis = new FileInputStream(tmp);
            while ((read = fis.read(bytes)) > 0) {
                raf.write(bytes, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dell on 2017-12-13.
 */
public class FileOutputStreamTest {

    /**
     * 使用jdk7处理流
     */
    @Test
    public void test() {
        try (FileInputStream fis = new FileInputStream("d:\\test.txt");
             FileOutputStream fos = new FileOutputStream("d:\\copy.txt");) {

            byte[] bytes = new byte[100];
            int read = 0;
            while ((read = fis.read(bytes)) > 0) {
                fos.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    /**
     * 使用手动关闭流
     */
    @Test
    public void test_close() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("d:\\test.txt");

            fos = new FileOutputStream("d:\\copy.txt");
            byte[] bytes = new byte[100];
            int read = 0;
            while ((read = fis.read(bytes)) > 0) {
                fos.write(bytes, 0, read);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

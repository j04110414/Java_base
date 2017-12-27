package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by dell on 2017-12-13.
 */
public class FileInputStreamTest {

    /**
     * 未使用缓冲读取文件字节流
     */
    @Test
    public void read_noBuffer() throws IOException {
        FileInputStream fis = new FileInputStream("d:\\test.txt");
        int read = 0;
        while ((read = fis.read()) != -1) {
            System.out.println(new String());
        }
    }


    @Test
    public void read_buffer() throws IOException {
        FileInputStream fis = new FileInputStream("d:\\test.txt");
        byte[] bytes = new byte[100];
        int read = 0;
        while ((read = fis.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, read));
        }

    }
}

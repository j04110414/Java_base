package io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dell on 2017-12-13.
 */
public class FileReaderTest {
    @Test
    public void read() throws IOException {
        FileReader fr = new FileReader(new File("d:\\test.txt"));
        char[] chars = new char[32];
        int read = 0;
        while ((read = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, read));
        }
    }
}

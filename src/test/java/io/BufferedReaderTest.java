package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dell on 2017-12-13.
 */
public class BufferedReaderTest {
    @Test
    public void readLine() {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\test.txt"));
             BufferedReader br = new BufferedReader(isr);) {
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

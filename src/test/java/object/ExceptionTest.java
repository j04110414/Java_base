package object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dell on 2017-12-12.
 */
public class ExceptionTest {

    public void test() {
        try (InputStream is = new FileInputStream("");
             OutputStream os = new FileOutputStream("");
        ) {
            is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

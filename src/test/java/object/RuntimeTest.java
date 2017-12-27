package object;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by dell on 2017-12-06.
 */
public class RuntimeTest {
    @Test
    public void gc() {
        Runtime.getRuntime().gc();
    }

    @Test
    public void availableProcessors() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void memory() {
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }


    @Test
    public void exct() {
        try {
            Runtime.getRuntime().exec("D:\\Program Files\\WinRAR\\WinRAR.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

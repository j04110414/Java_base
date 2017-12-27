package object;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * Created by dell on 2017-12-06.
 */
public class SystemTest {

    @Test
    public void getenv() {
        Map<String, String> params = System.getenv();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }

    @Test
    public void getProperties() {
        Properties properties = System.getProperties();
        properties.entrySet();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }
    }

    @Test
    public void currentTimeMillis() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void gc() {
        System.gc();
    }

}

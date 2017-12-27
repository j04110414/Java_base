package object;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by dell on 2017-12-11.
 */
public class RandomTest {

    @Test
    public void random() {
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }

    @Test
    public void message() {
        String msg = "Helllo {0}! 现在时间：{1}";
        System.out.println(MessageFormat.format(msg, "lyrics", new Date()));
    }
}

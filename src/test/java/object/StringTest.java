package object;

import org.junit.Test;

/**
 * Created by dell on 2017-12-11.
 */
public class StringTest {
    @Test
    public void string(){
        String name = "lyrics";
        System.out.println(name.charAt(2));
        System.out.println(name.codePointAt(2));
        System.out.println(name.codePointBefore(2));
        System.out.println(name.codePointCount(2,5));

        System.out.println(name.compareTo("lyr"));
        System.out.println(name.concat("ri"));
        System.out.println(name.getBytes());
        System.out.println(name.substring(1));
        System.out.println(name.hashCode());
        System.out.println(name.endsWith("s"));
//        System.out.println(name.intern());
        String name1 = "lyrics";
        System.out.println(name == name1);

        System.out.println(name.toUpperCase());
    }

}

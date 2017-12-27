package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017-12-12.
 */
public class GenericTest<T> {

    /**
     * 泛型构造器
     */
    public <T> GenericTest(T t) {
        System.out.println(t);
    }

    /**
     * 有返回值泛型方法
     */
    public <T> T test(T t) {

        return t;
    }

    /**
     * 无返回值泛型方法
     * @param t
     * @param <T>
     */
    public <T> void noParams(T t) {
        System.out.println(t);
    }


    public static void main(String[] args) {
        new GenericTest("jing");
        new GenericTest(10000);
        new GenericTest(new ArrayList());
        new GenericTest(new StringBuffer().append("44444"));

        System.out.println(new GenericTest("lyrics").test("jing"));

        new GenericTest<String>("chen").noParams("123456");
    }

}

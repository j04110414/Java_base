package object;

/**
 * Created by dell on 2017-12-05.
 */
public interface InterfaceTest {

    void test();

    /**
     * jdk8 新特性default方法
     */
    default String getStr() {
        return "Hello World!";
    }
}

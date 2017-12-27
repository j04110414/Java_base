package object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by dell on 2017-12-04.
 */
public class ObjectTest implements Cloneable {

    private String name = "jing";

    private String age;

    private String addr;

    static List list;

    public ObjectTest() {
    }

    public ObjectTest(String name) {
        this(name, null, null);
    }

    public ObjectTest(String age, String addr) {
        this(null, age, addr);
    }

    public ObjectTest(String name, String age, String addr) {
        this.age = age;
        this.addr = addr;
        this.name = name;
    }

    public String test(String str) {
        return "123";
    }

    public void newList() {
        new ArrayList<>();
    }




    public static void main(String[] args) {
        //clone只是复制了引用，而不是把整个对象复制,属于浅克隆
        try {
            ObjectTest objectTest = new ObjectTest();
            ObjectTest test = (ObjectTest) objectTest.clone();

            System.out.println(objectTest == test);
            System.out.println(objectTest.name == objectTest.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(Objects.hashCode(list));
        System.out.println(Objects.toString(list));
    }
}

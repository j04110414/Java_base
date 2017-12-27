package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dell on 2017-12-14.
 */
public class SerializableTest {

    /**
     * 序列化对象
     */
    @Test
    public void writeObj() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));

            Person person = new Person();
            person.setName("lyrics");
            person.setId("1234567890");

            oos.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 反序列化对象 序列化与反序列化对象的serialVersionUID必须一直，如果不一致，将导致序列化失败
     * 错误信息：java.io.InvalidClassException:
     * io.Person; local class incompatible: stream classdesc serialVersionUID = 1109692436613378495,
     * local class serialVersionUID = -5007906744853413273
     */
    @Test
    public void readObj() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

            Person person = (Person) ois.readObject();

            System.out.println(person.getName());
            System.out.println(person.getId());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

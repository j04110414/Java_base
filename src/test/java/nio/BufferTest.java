package nio;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * Created by dell on 2017-12-15.
 */
public class BufferTest {
    @Test
    public void test() {
        //初始化buffer,容量为10，位置position为0，界限limit为10
        CharBuffer buffer = CharBuffer.allocate(10);
        System.out.println(buffer.position() + "-" + buffer.limit() + "-" + buffer.capacity());

        //添加三个值后，位置position变成3
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        System.out.println(buffer.position() + "-" + buffer.limit() + "-" + buffer.capacity());

        //调用flip后，位置变为0，界限变为3
        buffer.flip();
        System.out.println(buffer.position() + "-" + buffer.limit() + "-" + buffer.capacity());

        //调用clear后，位置position为0，界限limit为10
        buffer.clear();
        System.out.println(buffer.position() + "-" + buffer.limit() + "-" + buffer.capacity());

        System.out.println(buffer.get(2));

    }
}

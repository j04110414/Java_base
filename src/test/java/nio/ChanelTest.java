package nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2017-12-15.
 */
public class ChanelTest {
    @Test
    public void test() {
        try {
            File file = new File("d:\\test.txt");
            FileInputStream fis = new FileInputStream(file);
            FileChannel channel = fis.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            FileChannel outChannel = new FileOutputStream("d:\\copy.txt").getChannel();
            outChannel.write(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            File file = new File("d:\\test.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            FileChannel channel = raf.getChannel();
            ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            channel.position(file.length());

            channel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

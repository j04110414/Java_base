package nio;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017-12-15.
 */
public class FilesTest {
    @Test
    public void test() {
        try {
            Files.copy(Paths.get("d:", "test.txt"), new FileOutputStream("d:\\copy.txt"));

            List<String> list = Files.readAllLines(Paths.get("d:", "test.txt"));
            for (String str : list) {
                System.out.println(str);
            }

            List<String> strs = new ArrayList<>();
            strs.add("我是一只鱼，水里游来游去");
            Files.write(Paths.get("test.txt"), strs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            Path path = Paths.get("test.txt");
            BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes attributes = basicFileAttributeView.readAttributes();
            System.out.println(attributes.creationTime());
            System.out.println(attributes.fileKey());
            System.out.println(attributes.isOther());
            System.out.println(attributes.lastAccessTime());

            FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
            System.out.println(fileOwnerAttributeView.getOwner());

            UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(path,UserDefinedFileAttributeView.class);
            userDefinedFileAttributeView.list();

            DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path,DosFileAttributeView.class);
                    dosFileAttributeView.name();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

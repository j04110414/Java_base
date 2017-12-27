package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by dell on 2017-12-13.
 */
public class FileTest {
    @Test
    public void file() throws IOException {
        File file = new File("d:\\test.txt");
        System.out.println(file.canRead());
        System.out.println(file.canExecute());
        System.out.println(file.canWrite());
        System.out.println(file.exists());

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());

        System.out.println(file.getFreeSpace());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.length());
        System.out.println(file.lastModified());

        System.out.println(file.listFiles());
//        System.out.println(file.delete());
        System.out.println(file.createNewFile());
        System.out.println(file.toPath());

        System.out.println(Arrays.toString(file.listRoots()));
    }
}

package object;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dell on 2017-12-06.
 */
public final class FinalTest {

    private final String str = "";

    private final Son son = new Son();

    private final String[] ss = new String[]{"1", "2", "3"};

    public final void getName() {
        System.out.println("");
    }

    public static void main(String[] args) {
//        new FinalTest().str = "123";

        FinalTest test = new FinalTest();
        test.son.setName("wang");

        Arrays.fill(test.ss, "www");
        System.out.println(Arrays.toString(test.ss));

//        test.ss = new String[]{};
    }
}

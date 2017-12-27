package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

/**
 * Created by dell on 2017-12-04.
 */
public class ArraysTest {

    /**
     * 二分法查找数据在数组的索引
     */
    @Test
    public void binarySearch() {
        String[] ss = new String[]{"1", "5", "2", "3", "4"};
        int index = Arrays.binarySearch(ss, "3");
        System.out.println(index);

        int index2 = Arrays.binarySearch(ss, "sex");
        System.out.println(index2);
    }

    /**
     * 复制原始数组，并生成指定长度的新数组，当原始数组长度小于新数组时，新数组复制原始数组所有数据，
     * 并给大于原始原始数组长度的部分，int类型默认补0，boolean类型默认补false,type默认补null
     */
    @Test
    public void copyOf() {
        String[] ss = new String[]{"1", "5", "2", "3", "4"};

        String[] ss2 = Arrays.copyOf(ss, 10);
        System.out.println("type类型长度大于原始数组：");
        for (String s : ss2) {
            System.out.print(s + ",");
        }

        System.out.println();

        String[] ss3 = Arrays.copyOf(ss, 3);
        System.out.println("type类型长度小于原始数组：");
        for (String s : ss3) {
            System.out.print(s + ",");
        }

        System.out.println();

        int[] ints = new int[]{1, 2, 3, 4, 5};

        int[] nints = Arrays.copyOf(ints, 10);
        System.out.println("int类型长度小于原始数组：");
        for (int i : nints) {
            System.out.print(i + ",");
        }

        System.out.println();

        boolean[] bools = new boolean[]{true, true, false, false};

        boolean[] bs = Arrays.copyOf(bools, 10);
        System.out.println("boolean类型长度小于原始数组：");
        for (boolean i : bs) {
            System.out.print(i + ",");
        }
    }


    /**
     * 把数组元素复制成给定值
     */
    @Test
    public void fill() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6", "ma"};

        Arrays.fill(ss, "hello");
        for (String s : ss) {
            System.out.println(s);
        }

        System.out.println("*********************************");

        Arrays.fill(ss, 3, 5, "feng");
        for (String s : ss) {
            System.out.println(s);
        }
    }

    /**
     * 把数组数据转换成字符串，多个数据用逗号，分割
     */
    @Test
    public void arrays_toString() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6", "ma"};
        System.out.println(Arrays.toString(ss));
    }

    /**
     * 对数组数据进行排序
     */
    @Test
    public void sort() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6", "ma"};
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));
    }

    /**
     * 数组直接转化成stream
     */
    @Test
    public void stream() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6", "ma"};
        Arrays.stream(ss);
    }


    /**
     * 对现有数据进行处理后，赋值处理后的结果
     */
    @Test
    public void parallelPrefix() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6"};
        Arrays.parallelPrefix(ss, new BinaryOperator() {

            @Override
            public Object apply(Object left, Object right) {
                return right + "0";
            }
        });

        System.out.println(Arrays.toString(ss));


        int[] ints = new int[]{1, 2, 3, 4, 5};

        Arrays.parallelPrefix(ints, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                System.out.println(right);
                return right * 10;
            }
        });

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 并发排序
     */
    @Test
    public void parallelSort() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6"};
        Arrays.parallelSort(ss);
        System.out.println(Arrays.toString(ss));

    }

    /**
     * 使用指定的生成器为所有数组元素设值，
     */
    @Test
    public void setAll() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6"};
        Arrays.setAll(ss, new IntFunction<String>() {
            @Override
            public String apply(int value) {
                return ss[value] + "0";
            }
        });
        System.out.println(Arrays.toString(ss));

    }

    /**
     * 数组转换成集合List
     */
    @Test
    public void toList() {
        String[] ss = new String[]{"1", "5", "2", "3", "4", "6"};
        System.out.println(Arrays.asList(ss));
    }
}

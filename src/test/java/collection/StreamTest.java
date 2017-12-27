package collection;

import com.java.base.collection.User;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by dell on 2017-11-29.
 */
public class StreamTest {

    /**
     * 构造流Stream的几种常见方法
     */
    @Test
    public void create_stream() {
        //
        Stream stream = Stream.of("111", "222", "333");

        String[] ss = new String[]{"a", "b", "c"};
        Stream stream22 = Stream.of(ss);
        Stream stream2 = Arrays.stream(ss);

        List<String> list = Arrays.asList(ss);
        Stream stream3 = list.stream();

    }

    /**
     * Stream数据流转换其他数据结构
     */
    @Test
    public void streamTo_obj() {
        Stream<String> stream = Stream.of("111", "222", "333");
        String[] ss = stream.toArray(String[]::new);
        System.out.println(ss);

        Stream<String> stream2 = Stream.of("a", "b", "c");
        List<String> list = stream2.collect(Collectors.toList());
        System.out.println(list);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        ArrayList<String> list2 = stream3.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list2);

        Stream<String> stream4 = Stream.of("aaa", "aaa", "ccc");
        Set<String> set = stream4.collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
    }


    @Test
    public void collect() {
        Stream<String> stream = Stream.of("111", "222", "333", "222", "444");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        Stream<String> stream2 = Stream.of("111", "222", "333", "222", "444");
        Set<String> set = stream2.collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println(set);
    }


    /**
     * Stream中间操作
     */
    @Test
    public void streamIntermediate() {
        Stream<String> stream = Stream.of("111", "222", "333", "222", "444");
        //过滤不等于222的字符-filter
        List<String> list = stream.filter(e -> !e.equals("222")).collect(Collectors.toList());
        System.out.println(list);

        //取前两个-limit
        Stream<String> stream2 = Stream.of("111", "222", "333", "222", "444");
        List<String> list2 = stream2.limit(2).collect(Collectors.toList());
        System.out.println(list2);

        //stream函数处理-map
        Stream<String> stream3 = Stream.of("111", "222", "333", "222", "444");
        List<Integer> list3 = stream3.map(e -> Integer.valueOf(e)).collect(Collectors.toList());
        System.out.println(list3);

        Stream<String> stream4 = Stream.of("111", "222", "333", "222", "444");
        List<String> list4 = stream4.distinct().collect(Collectors.toList());
        System.out.println(list4);

        //跳过前面几个-skip
        Stream<String> stream5 = Stream.of("111", "222", "333", "222", "444");
        List<String> list5 = stream5.skip(2).collect(Collectors.toList());
        System.out.println(list5);


        Stream<String> stream6 = Stream.of("111", "222", "333", "222", "444");
        List<String> list6 = stream6.skip(2).collect(Collectors.toList());
        System.out.println(list6);
    }


    /**
     * stream中间操作
     */
    @Test
    public void stream_intermediate() {
        Stream<String> stream = Stream.of("666", "111", "222", "333", "555", "222", "444");
        List<String> list = stream
                .distinct() //去重-{"666", "111", "222", "333", "555", "444"}
                .filter(e -> !e.equals("222")) //过滤掉111-{"666", "111", "333", "555", "444"}
                .skip(1) //跳过第一个-{"111", "333", "555", "444"}
                .limit(4) //去前面4个-{"111", "333", "555", "444"}
                .sorted() //排序-{"111", "333", "444", "555"}
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 返回一个对当前所有元素执行执行mapper之后的结果组成的Stream。
     * 直观的说，就是对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，
     * 但元素的类型取决于转换之后的类型。
     */
    @Test
    public void stream_intermediate_map() {
        Stream<String> stream = Stream.of("aac", "bsd", "cra");
        //取最后一个字母对应的整数型
        List<Integer> list = stream.map(e -> {
            return Integer.valueOf(e.charAt(e.length() - 1));
        }).sorted().collect(Collectors.toList());
        System.out.println(list); //[99, 100, 101]
    }

    @Test
    public void stream_flatMap() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(5, 4, 3));
        List<Integer> list = stream.flatMap(lt -> lt.stream()).collect(Collectors.toList());
        System.out.println(list);


    }

    /**
     * 并发stream
     */
    @Test
    public void parallelStream() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        list.stream().forEach(e -> System.out.println(e));

        System.out.println("------------------------------------------------------");

        List<String> li = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        li.parallelStream().forEach(e -> System.out.println(e));
    }

    /**
     * 使用reduce取最长的的字符
     */
    @Test
    public void stream_reduce() {
        Stream<String> stream = Stream.of("i", "love", "you");
        Optional<String> opt = stream.reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        System.out.println(opt.get());
    }

    @Test
    public void joining() {
        Stream<String> stream = Stream.of("i", "love", "you");
        String str = stream.collect(Collectors.joining("-", "{", "}"));
        System.out.println(str); //{i-love-you}
//        String str2 = stream.collect(Collectors.joining("-"));
//        System.out.println(str2); //i-love-you
//        String str3 = stream.collect(Collectors.joining());
//        System.out.println(str3); //iloveyou
    }
}

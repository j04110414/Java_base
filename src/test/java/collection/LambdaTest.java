package collection;

import com.java.base.collection.Lambda;
import com.java.base.collection.User;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dell on 2017-11-29.
 */
public class LambdaTest {



    /************************************************forEach****************************************/

    /**
     * jdk增强的for循环
     */
    @Test
    public void forEach_jdk() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        for (String str : list) {
            if (str.length() > 3) {
                System.out.println(str);
            }
        }
    }

    /**
     * 使用内部类Consumer实现forEach
     */
    @Test
    public void foreach_consumer() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3) {
                    System.out.println(s);
                }
            }
        });
    }

    /**
     * 使用lambda表达式实现forEach
     */
    @Test
    public void forEach_lambda() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        list.forEach(str -> {
            if (str.length() > 3) {
                System.out.println(str);
            }
        });
    }

    /*********************************************forEach******************************************/

    /*********************************************removeIf*****************************************/

    /**
     * 对容器元素进行删除必须使用迭代器，否则会抛ConcurrentModificationException异常
     */
    @Test
    public void removeIf_iterator() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");
        list.add("too");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("too")) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }

    /**
     * 使用内部类Predicate实现
     */
    @Test
    public void removeif_predicate() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");
        list.add("too");

        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.equals("too")) {
                    return true;
                }
                return false;
            }
        });

        System.out.println(list);
    }


    /**
     * 使用lambda表达式实现
     */
    @Test
    public void removeif_lambda() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");
        list.add("too");

        list.removeIf(str -> str.equals("too"));

        System.out.println(list);
    }

    /*********************************************removeIf*****************************************/

    /*******************************************replaceAll*****************************************/

    /**
     * 内部类UnaryOperator实现对每个元素执行operator指定的操作，并用操作结果来替换原来的元素
     */
    @Test
    public void replaceAll_unaryoperator() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.equals("love"))
                    return s.toUpperCase();
                return s;
            }
        });

        System.out.println(list);
    }

    /**
     * lambda实现replaceAll
     */
    @Test
    public void replaceAll_lambda() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        list.replaceAll(str -> {
            if (str.equals("love"))
                return str.toUpperCase();
            return str;

        });

        System.out.println(list);
    }

    /*******************************************replaceAll*****************************************/

    /**********************************************sort********************************************/


    /**
     * 使用Collections接口实现排序
     */
    @Test
    public void sort_collections() {
        List<String> list = new ArrayList<>();
        list.add("to");
        list.add("i");
        list.add("love");
        list.add("you");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });

        System.out.println(list);
    }

    /**
     * 内部类Comparator实现排序，跟Collections接口实现一样
     */
    @Test
    public void sort_comparator() {
        List<String> list = new ArrayList<>();
        list.add("to");
        list.add("i");
        list.add("love");
        list.add("you");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });

        System.out.println(list);
    }

    /**
     * sort使用lambda表达式实现排序
     */
    @Test
    public void sort_lambda() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");

        list.sort((str1, str2) -> {
            return str1.length() - str2.length();
        });

        System.out.println(list);
    }
    /**********************************************sort********************************************/

    /******************************************Map-forEach*****************************************/

    /**
     * 用Map.Entry实现增强for循环
     */
    @Test
    public void map_for() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }


    /**
     * 内部类BiConsumer实现forEach
     */
    @Test
    public void map_forEach_biConsumer() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "-" + value);
            }
        });
    }


    /**
     * Map-lambda实现forEach
     */
    @Test
    public void map_forEach_lambda() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.forEach((key, val) -> {
            System.out.println(key + "-" + val);
        });
    }
    /******************************************Map-forEach*****************************************/

    /******************************************getOrDefault****************************************/

    @Test
    public void map_get() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        if (null != map.get("adrr")) {
            System.out.println(map.get("addr"));
        } else {
            System.out.println("IsEmpty");
        }
    }

    @Test
    public void map_getOrDefault() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        System.out.println(map.getOrDefault("name", "chen"));
        System.out.println(map.getOrDefault("addr", "IsEmpty"));
    }
    /******************************************getOrDefault****************************************/

    /******************************************putIfAbsent*****************************************/

    /**
     * 在不存在key值的映射或映射值为null时，给才将value指定的值放入到Map中，否则不对Map做更改
     */
    @Test
    public void putIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.putIfAbsent("name", "xian");
        map.putIfAbsent("addr", "xian");

        System.out.println(map);
    }
    /******************************************putIfAbsent*****************************************/
    /********************************************remove********************************************/

    /**
     * 只有key和value都映射到map，才删除该值
     */
    @Test
    public void remove() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.remove("name", "jing");
        System.out.println(map);

        map.remove("name", "wang");
        System.out.println(map);
    }
    /********************************************remove********************************************/

    /******************************************replaceAll******************************************/

    @Test
    public void map_replaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.replaceAll(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s2.toUpperCase();
            }
        });

        System.out.println(map);
    }

    @Test
    public void map_replaceAll_lambda() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.replaceAll((k, v) -> {
            return v.toUpperCase();
        });

        System.out.println(map);
    }

    /******************************************replaceAll******************************************/

    /*********************************************merge********************************************/
    @Test
    public void map_merge() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.merge("name", "wang", (k, v) -> {
            return "qu";
        });

        System.out.println(map);
    }


    @Test
    public void map_compute() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.compute("name", (k, v) -> "C");
        System.out.println(map);
    }


    /**
     * 只有在当前Map中不存在key值的映射或映射值为null时，才调用mappingFunction
     */
    @Test
    public void map_computeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.computeIfAbsent("name", (k) -> {
            return "qu";
        });
        System.out.println(map);
    }

    /**
     * 跟computeIfAbsent相反，在key，与value相等时，替换
     */
    @Test
    public void map_computeIfPresent() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wang");
        map.put("age", "25");
        map.put("gender", "women");

        map.computeIfPresent("name", (k, v) -> {
            return "qu";
        });
        System.out.println(map);
    }
    /*********************************************merge********************************************/
}

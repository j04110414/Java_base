package com.java.base.collection;

import com.sun.javafx.scene.control.skin.ListViewSkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by dell on 2017-11-29.
 */
public class Lambda {

    public void list_lambda() {
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        list.forEach(e -> System.out.println(e));
        System.out.println("------------------------------");
        list.forEach(System.out::println);
    }

    public void list2_lambda() {
        List<String> list = new ArrayList<String>();
        list.add("1234");
        list.add("2234");
        list.add("3234");
        list.add("4234");

        List<String> newList = new ArrayList<>();
        list.forEach(e -> {
            newList.add(e);
        });

        System.out.println(newList);
    }

    public void list_stream() {
        List<String> list = new ArrayList<String>();
        list.add("4234");
        list.add("1224");
        list.add("3234");
        list.add("2224");
        list.add("1224");

        list.stream().limit(6).distinct().filter(e -> e.contains("34")).forEachOrdered(e -> {
            System.out.println(e);
        });

        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }

    public void list_obj() {
        List<Object> list = new ArrayList<>();
        list.add(new Lambda());
        list.add(new Lambda());
        list.add(new Lambda());
        list.add(new Lambda());

        list.stream().distinct().forEach(e -> {
            System.out.println(e);
        });

        Set<String> set = new HashSet<>();
        set.stream().findAny();
    }


}

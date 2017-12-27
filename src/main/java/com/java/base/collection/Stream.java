package com.java.base.collection;

import java.util.stream.IntStream;

/**
 * Created by dell on 2017-11-29.
 */
public class Stream {

    public void stream() {
        IntStream intStream = IntStream.builder().add(1).add(2).add(3).build();

//        System.out.println("stream和:" + intStream.sum());
        System.out.println("stream最大:" + intStream.max().getAsInt());
        System.out.println("stream最小:" + intStream.min().getAsInt());
    }
}

package io;

import java.io.Serializable;

/**
 * Created by dell on 2017-12-14.
 */
public class Person implements Serializable {

    private transient String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

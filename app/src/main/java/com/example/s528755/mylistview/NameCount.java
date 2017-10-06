package com.example.s528755.mylistview;

/**
 * Created by S528755 on 10/2/2017.
 */

public class NameCount {
    public String name;
    public Integer count;
    public NameCount(String name, int count) {

        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getcount() {
        return count;
    }


    @Override
    public String toString() {
        return "NameCount{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}


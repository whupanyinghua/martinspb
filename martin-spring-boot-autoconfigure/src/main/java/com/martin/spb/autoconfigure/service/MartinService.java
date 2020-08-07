package com.martin.spb.autoconfigure.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类MartinService的实现描述：
 *
 * @author panyinghua 2020-8-7 14:59
 */
public class MartinService {

    private List<String> names = new ArrayList<>();

    public MartinService(List<String> names) {
        this.names = names;
    }

    public void hello() {
        System.out.println("hello:"+names);
    }
}

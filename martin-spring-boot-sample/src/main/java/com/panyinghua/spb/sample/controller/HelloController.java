package com.panyinghua.spb.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类HelloController的实现描述：HelloController
 *
 * @author panyinghua 2020-8-7 13:53
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "hello from martin's spring boot project!";
    }
}

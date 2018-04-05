package com.bow.cloud.eureka.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 计算服务
 * @author vv
 * @since 2018/3/27.
 */
@RequestMapping("/calculate")
@RestController
public class Calculator {

    @RequestMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        System.out.println("add ( "+a+", "+b+" )");
        return a+b;
    }

    @RequestMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        System.out.println("sub ( "+a+", "+b+" )");
        return a-b;
    }
}

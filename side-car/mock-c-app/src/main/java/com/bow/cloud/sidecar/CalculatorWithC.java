package com.bow.cloud.sidecar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟用CPP实现的计算服务
 * http://localhost:9004/calculate/add?a=1&b=2
 * @author vv
 * @since 2018/4/7.
 */
@RequestMapping("/calculate")
@RestController
public class CalculatorWithC {

    @RequestMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        System.out.println("add ( " + a + ", " + b + " )");
        System.out.println("CPP");
        return a + b;
    }

    @RequestMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        System.out.println("sub ( " + a + ", " + b + " )");
        return a - b;
    }
}

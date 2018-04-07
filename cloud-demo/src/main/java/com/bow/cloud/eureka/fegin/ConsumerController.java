package com.bow.cloud.eureka.fegin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * localhost:9002/cal/add?a=1&b=2
 */
@RestController
@RequestMapping("/cal")
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ICalculator calculator;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public int add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        System.out.println("receive " + a +", "+ b);
        // 客户端通过FeignCalculator计算
        return calculator.add(a, b);
    }
}
package com.bow.cloud.eureka.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 一个假计算器
 * @author vv
 * @since 2018/3/27.
 */
@FeignClient(value = "provider-service")
public interface FeignCalculator {

    @RequestMapping(value = "/calculate/add",method = RequestMethod.GET)
    int add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b );

    @RequestMapping(value = "/calculate/sub",method = RequestMethod.GET)
    int sub(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b );
}
